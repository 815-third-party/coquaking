package com.codesquad.coquaking.web;

import com.codesquad.coquaking.domain.Archive;
import com.codesquad.coquaking.schedule.ReactionCollector;
import com.codesquad.coquaking.service.ArchiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/archives")
public class ArchiveController {

    private final ArchiveService archiveService;
    private final ReactionCollector reactionCollector;

    public ArchiveController(ArchiveService archiveService, ReactionCollector reactionCollector) {
        this.archiveService = archiveService;
        this.reactionCollector = reactionCollector;
    }

    @GetMapping
    public ResponseEntity<List<Archive>> winner() {
        List<Archive> archives = archiveService.getWinner();
        ResponseEntity<List<Archive>> result = new ResponseEntity<>(archives, HttpStatus.OK);
        return result;
    }

    @GetMapping("/generate")
    @Transactional
    public void generate() {
        reactionCollector.collect();
        archiveService.addReactionWinner();
    }

    @GetMapping("/text")
    public void generateText() {
        archiveService.addTextWinner();
    }
}

