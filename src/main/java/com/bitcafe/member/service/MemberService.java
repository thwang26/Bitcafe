package com.bitcafe.member.service;

import com.bitcafe.member.domain.Member;
import com.bitcafe.member.exception.MemberErrorCode;
import com.bitcafe.member.exception.MemberException;
import com.bitcafe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NO_MEMBER));
    }

    public Member getMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NO_MEMBER));
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public boolean existMember(String email) {
        return memberRepository.existsByEmail(email);
    }
}
