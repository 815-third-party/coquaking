package com.codesquad.coquaking.web;

import com.codesquad.coquaking.domain.UserRepository;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String authorize(@RequestBody String json) {
        String challenge = JsonPath.read(json, "$.challenge");
        return challenge;
    }
}
