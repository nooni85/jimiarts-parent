package com.jimiarts.models.member.service;

import com.jimiarts.models.ModelTests;
import com.jimiarts.models.member.entity.Member;
import com.jimiarts.models.member.exception.MemberNotFoundException;
import com.jimiarts.models.role.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest extends ModelTests {
    final String EMAIL = "test@test.com";

    @Autowired
    MemberService memberService;

    @Autowired
    RoleService roleService;

    @Test
    public void deleteMemberShouldThrowMemberNotFoundExceptionTest() {
        assertThrows(MemberNotFoundException.class, () -> {
            memberService.deleteMemberByEmail(EMAIL);
            memberService.deleteMemberByEmail(EMAIL);
        });

        assertNull(memberService.findMemberByEmail(EMAIL));
    }
}