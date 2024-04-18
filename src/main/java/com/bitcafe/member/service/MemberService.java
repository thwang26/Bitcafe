package com.bitcafe.member.service;

import com.bitcafe.global.security.service.JwtService;
import com.bitcafe.member.domain.Member;
import com.bitcafe.member.dto.Authentication;
import com.bitcafe.member.dto.RegisterRequest;
import com.bitcafe.member.exception.MemberErrorCode;
import com.bitcafe.member.exception.MemberException;
import com.bitcafe.member.repository.MemberRepository;
import com.bitcafe.member.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public Authentication.Response register(RegisterRequest request) {
        Member member = Member.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        memberRepository.save(member);
        String jwtToken = jwtService.generateToken(member);
        return Authentication.Response.builder()
                .token(jwtToken)
                .build();
    }

    public Authentication.Response authenticate(Authentication.Request request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        ); // TODO : 리팩토링
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(member);
        return Authentication.Response.builder()
                .token(jwtToken)
                .build();
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NO_MEMBER));
    }
}
