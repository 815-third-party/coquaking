package com.codesquad.coquaking.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReactionCollectorTest {
    @Autowired
    private ReactionCollector reactionCollector;

    @Test
    void name() {
        reactionCollector.collect();
    }
}