package com.codesquad.coquaking.web;

import com.codesquad.coquaking.dto.TextRequestDto;
import com.codesquad.coquaking.service.ScoreService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversation")
public class SlackController {
    private final ScoreService scoreService;

    public SlackController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public void consume(@RequestBody String json) {
        String slackId = JsonPath.read(json, "$.event.user");
        String text = JsonPath.read(json, "$.event.text");
        scoreService.add(new TextRequestDto(slackId, text));
    }
}
