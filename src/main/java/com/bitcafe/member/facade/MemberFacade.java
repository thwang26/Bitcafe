package com.bitcafe.member.facade;

import com.bitcafe.global.security.service.JwtService;
import com.bitcafe.member.domain.Member;
import com.bitcafe.member.dto.Authentication;
import com.bitcafe.member.dto.RegisterRequest;
import com.bitcafe.member.exception.MemberException;
import com.bitcafe.member.service.MemberService;
import com.bitcafe.member.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.bitcafe.member.exception.MemberErrorCode.ALREADY_EXISTS;
import static com.bitcafe.member.exception.MemberErrorCode.PASSWORD_NOT_MATCH;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Authentication.Response register(RegisterRequest request) {
        if (memberService.existMember(request.getEmail())) {
            throw new MemberException(ALREADY_EXISTS);
        }

        Member member = Member.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        memberService.save(member);
        String jwtToken = jwtService.generateToken(member);
        return Authentication.Response.builder()
                .token(jwtToken)
                .build();
    }

    public Authentication.Response authenticate(Authentication.Request request) {
        Member member = memberService.getMember(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberException(PASSWORD_NOT_MATCH);
        }

        String jwtToken = jwtService.generateToken(member);
        return Authentication.Response.builder()
                .token(jwtToken)
                .build();
    }
}
