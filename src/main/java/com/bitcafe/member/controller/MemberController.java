package com.bitcafe.member.controller;

import com.bitcafe.member.dto.Authentication;
import com.bitcafe.member.dto.RegisterRequest;
import com.bitcafe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Authentication.Response> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(memberService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Authentication.Response> authenticate(
            @RequestBody Authentication.Request request
    ) {
        return ResponseEntity.ok(memberService.authenticate(request));
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }
}
