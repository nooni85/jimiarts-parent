package com.jimiarts.models.member.service;

import com.jimiarts.models.ModelTests;
import com.jimiarts.models.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest extends ModelTests {
    @Autowired
    MemberService memberService;

    @Test
    public void memberCreateTest() {
        Member joowh85 = Member.builder()
                .username("joowh85").build();

        memberService.createMember(joowh85);
    }
}