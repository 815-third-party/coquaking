package com.codesquad.coquaking.schedule;

import com.codesquad.coquaking.service.ArchiveService;
import org.springframework.stereotype.Component;

@Component
public class WinnerResolver {
    private final ArchiveService archiveService;

    public WinnerResolver(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    public void resolveText() {
        archiveService.addTextWinner();
    }

    public void resolveReaction() {
        archiveService.addReactionWinner();
    }
}
