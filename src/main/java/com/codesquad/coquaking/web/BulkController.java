package com.codesquad.coquaking.web;

import com.codesquad.coquaking.domain.Score;
import com.codesquad.coquaking.domain.User;
import com.codesquad.coquaking.domain.UserRepository;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BulkController {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void setDefault() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForLocation("uri","https://slack.com/api/users.list")
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> value = new LinkedMultiValueMap<>();
        value.set("token", "xoxp-242583072180-586108482449-725729287348-c3d6ad36095b1dcfb08cf95c919977d1");

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(value, headers);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("https://slack.com/api/users.list", httpEntity, String.class);

        String body = stringResponseEntity.getBody();
        Score defaultScore = new Score(0, 0, 0);
        List<Object> all = JsonPath.read(body,"$.members");
        for (int i = 0; i < all.size(); i++) {
            String slackid = JsonPath.read(body, "$.members[0].id");
            String image = JsonPath.read(body, "$.members[0].profile.image_512");
            String name = JsonPath.read(body, "$.members[0].name");
            User user = new User(slackid, name, image, defaultScore);
            userRepository.save(user);
        }

    }

    @GetMapping("/")
    public void trigger(){
        setDefault();
    }

}
