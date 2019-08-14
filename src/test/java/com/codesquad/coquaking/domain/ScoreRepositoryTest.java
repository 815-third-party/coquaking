package com.codesquad.coquaking.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @Transactional
    public void name() {

        User user = testEntityManager.find(User.class, 1L);
        Score score = new Score(user, 10, 0, 0);

        User user2 = testEntityManager.find(User.class, 3L);
        Score score2 = new Score(user2, 20, 0, 0);

        User user3 = testEntityManager.find(User.class, 4L);
        Score score3 = new Score(user3, 30, 0, 0);

        scoreRepository.save(score);
        scoreRepository.save(score2);
        scoreRepository.save(score3);

        List<Long> users = scoreRepository.findTextWinner();
        assertThat(users.size()).isEqualTo(3);


        testEntityManager.flush();
        testEntityManager.clear();

        assertThat(testEntityManager.find(User.class, users.get(0)).getId()).isEqualTo(4L);
    }

}