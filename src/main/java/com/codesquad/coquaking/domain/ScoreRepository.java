package com.codesquad.coquaking.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query(value = "select user_id from (select score.user_id, sum(text_score) as s from score group by score.user_id order by s desc) t limit 2", nativeQuery = true)
    List<Long> findTextWinner();

    @Query(value = "select user_id from (select score.user_id, sum(reaction_score) as s from score group by score.user_id order by s desc) t limit 2", nativeQuery = true)
    List<Long> findReactionWinner();
}
