package com.codesquad.coquaking.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    private final ReactionCollector reactionCollector;
    private final WinnerResolver winnerResolver;

    public ScheduleTask(ReactionCollector reactionCollector, WinnerResolver winnerResolver) {
        this.reactionCollector = reactionCollector;
        this.winnerResolver = winnerResolver;
    }

    @Scheduled(cron = "0 0 22 * * ?")
    public void reaction() {
        reactionCollector.collect();
    }

    @Scheduled(cron = "0 0 23 * * ?")
    public void archiveText() {
        winnerResolver.resolveText();
    }

    @Scheduled(cron = "0 10 23 * * ?")
    public void archiveReaction() {
        winnerResolver.resolveReaction();
    }
}

