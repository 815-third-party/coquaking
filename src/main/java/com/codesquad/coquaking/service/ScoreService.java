package com.codesquad.coquaking.service;

import com.codesquad.coquaking.domain.Score;
import com.codesquad.coquaking.domain.ScoreRepository;
import com.codesquad.coquaking.domain.User;
import com.codesquad.coquaking.domain.UserRepository;
import com.codesquad.coquaking.dto.TextRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    public ScoreService(UserRepository userRepository, ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    public void addText(TextRequestDto dto) {
        User user = userRepository.findBySlackId(dto.getSlackId()).orElseThrow(IllegalAccessError::new);
        scoreRepository.save(new Score(user, dto.getText().length(), 0, 0));
    }

}
