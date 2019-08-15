package com.codesquad.coquaking.web;

import com.codesquad.coquaking.domain.Score;
import com.codesquad.coquaking.domain.User;
import com.codesquad.coquaking.dto.TextRequestDto;
import com.codesquad.coquaking.service.ScoreService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/conversation")
public class SlackController {
    private final ScoreService scoreService;

    public SlackController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public void consume(@RequestBody String json) {
        System.err.println(json);
        String slackId = JsonPath.read(json, "$.event.user");
        String text = JsonPath.read(json, "$.event.text");
        Score score = scoreService.addText(new TextRequestDto(slackId, text));
        User user = score.getUser();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        MultiValueMap<String, String> value = new LinkedMultiValueMap<>();
        value.set("text", user.getName() + " 이(가) " + score.toString() + " 만큼 떠들고 있습니다");
        restTemplate.postForLocation("https://hooks.slack.com/services/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", value);
    }
}
