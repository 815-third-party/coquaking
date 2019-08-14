package com.codesquad.coquaking.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/conversation")
public class DemoController {

    @PostMapping
    public void consume(@RequestBody HashMap<String, Object> parameter) {
        System.out.println(parameter.get("event").toString());
    }
}
