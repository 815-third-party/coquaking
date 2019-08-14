package com.codesquad.coquaking.service;

import com.codesquad.coquaking.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArchiveService {
    private final ArchiveRepository archiveRepository;
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    public ArchiveService(ArchiveRepository archiveRepository, ScoreRepository scoreRepository, UserRepository userRepository) {
        this.archiveRepository = archiveRepository;
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

    public List<Archive> getWinner() {
        return archiveRepository.findFirst3ByOrderByIdDesc();
    }

    public void addTextWinner() {
        List<Long> ids = scoreRepository.findTextWinner();
        persistArchive(Category.TEXT, ids);
    }

    public void addReactionWinner() {
        List<Long> ids = scoreRepository.findReactionWinner();
        persistArchive(Category.EMOJI, ids);
    }

    private void persistArchive(Category category, List<Long> ids) {
        User first = scoreRepository.findById(ids.get(0)).orElseThrow(IllegalAccessError::new).getUser();
        User second = scoreRepository.findById(ids.get(1)).orElseThrow(IllegalAccessError::new).getUser();
        User third = scoreRepository.findById(ids.get(2)).orElseThrow(IllegalAccessError::new).getUser();

        archiveRepository.save(new Archive(category, first, second, third));
    }
}
