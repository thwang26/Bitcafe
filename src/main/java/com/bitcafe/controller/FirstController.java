package com.bitcafe.controller;

import com.bitcafe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class FirstController {
    private final Environment env;
    private final MemberService memberService;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello World!3", HttpStatus.OK);
    }

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @GetMapping("/create")
    public String create() {
        memberService.create();
        return "ok";
    }
}
