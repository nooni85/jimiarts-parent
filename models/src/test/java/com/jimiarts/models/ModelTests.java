package com.jimiarts.models;

import com.jimiarts.models.member.entity.Member;
import com.jimiarts.models.member.service.MemberService;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ModelTests {
    protected final String EMAIL = "test@test.com";

    @Autowired
    MemberService memberService;

    public Member createMember() {
        Member joowh85 = Member.builder()
                .email(EMAIL)
                .password("1234")
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .username("joowh85").build();

        memberService.createMember(joowh85);
        Member memberByEmail = memberService.findMemberByEmail(joowh85.getEmail());
        assertNotNull(memberByEmail);

        return joowh85;
    }

    public void deleteMember() {
        Member memberByEmail = memberService.findMemberByEmail(EMAIL);
        if (memberByEmail == null) {
            createMember();
        }
        memberService.deleteMemberByEmail(EMAIL);

        assertNull(memberService.findMemberByEmail(EMAIL));
    }
}
