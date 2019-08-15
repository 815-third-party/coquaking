package com.codesquad.coquaking.schedule;

import com.codesquad.coquaking.domain.Score;
import com.codesquad.coquaking.domain.ScoreRepository;
import com.codesquad.coquaking.domain.User;
import com.codesquad.coquaking.domain.UserRepository;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ReactionCollector {
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    public ReactionCollector(UserRepository userRepository, ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    public void collect() {
        List<User> users = userRepository.findAll();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> value = new LinkedMultiValueMap<>();
        value.set("token", "xoxp-242583072180-586108482449-727095593333-9b7a2bd35fcd3115001da0aa03055157");
        for (User user : users) {
            int count = 0;
            value.set("user", user.getSlackId());
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(value, headers);
            String stringResponse =
                    restTemplate
                            .postForEntity("https://slack.com/api/reactions.list",
                                    httpEntity, String.class).getBody();
            int size = JsonPath.read(stringResponse, "$.items.length()");
            for (int i = 0; i < size; i++) {
                try {
                    count += (int) JsonPath.read(stringResponse, "$.items[" + i + "].message.reactions.length()");
                    System.out.println(count);
                } catch (PathNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("interrupt");
            }

            if (count == 0) {
                continue;
            }
            scoreRepository.save(new Score(user, 0, count, 0));
        }
    }
}