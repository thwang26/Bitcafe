package com.bitcafe.service;

import com.bitcafe.domain.Member;
import com.bitcafe.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void create() {
        Member member = Member.builder().nickname("taewon").email("email")
                .password("password").phoneNumber("pn").build();
        memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Member"));
    }
}
