package com.codesquad.coquaking.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArchiveServiceTest {
    @Autowired
    private ArchiveService archiveService;


    @Test
    void name() {
        archiveService.addReactionWinner();
    }
}