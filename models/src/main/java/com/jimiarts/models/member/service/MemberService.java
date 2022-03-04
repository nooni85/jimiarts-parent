package com.jimiarts.models.member.service;

import com.jimiarts.models.member.entity.Member;
import com.jimiarts.models.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public void createMember(Member member) {
        memberRepository.save(member);
    }
}
