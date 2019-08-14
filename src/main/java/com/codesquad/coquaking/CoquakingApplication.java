package com.codesquad.coquaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoquakingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoquakingApplication.class, args);
    }

}
