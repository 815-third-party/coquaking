package com.codesquad.coquaking.web;

import com.codesquad.coquaking.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArchiveControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArchiveRepository archiveRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        User user1 = userRepository.findById(1L).get();
        User user2 = userRepository.findById(3L).get();
        User user3 = userRepository.findById(4L).get();
        archiveRepository.save(new Archive(Category.TEXT, user1, user2, user3));
    }

    @Test
    void name() {
        webTestClient.get().uri("/api/archives")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.[0].first").isNotEmpty();


    }
}