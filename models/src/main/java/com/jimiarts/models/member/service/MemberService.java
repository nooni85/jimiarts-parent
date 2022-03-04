package com.jimiarts.models.member.service;

import com.jimiarts.models.member.entity.Member;
import com.jimiarts.models.member.exception.MemberNotFoundException;
import com.jimiarts.models.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Member findMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteMemberByEmail(String email) {
        Member memberByEmail = memberRepository.findMemberByEmail(email);

        if (memberByEmail == null) {
            throw new MemberNotFoundException(email + " not found.");
        }

        memberRepository.delete(memberByEmail);
    }
}
