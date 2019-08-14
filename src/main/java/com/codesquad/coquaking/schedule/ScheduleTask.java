package com.codesquad.coquaking.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Autowired
    private ReactionCollector reactionCollector;

    @Scheduled(cron = "0 0 23 * * ?")
    public void runTask() {
        reactionCollector.collect();
    }
}

