package com.codesquad.coquaking.service;

import com.codesquad.coquaking.domain.Archive;
import com.codesquad.coquaking.domain.ArchiveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArchiveService {
    private final ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    public List<Archive> getWinner() {
        return archiveRepository.findFirst3ByOrderByIdDesc();
    }
}
