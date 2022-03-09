package com.jimiarts.cwi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String doLogin() {
        return "auth/login";
    }

    @GetMapping("/join")
    public String join() {
        return "auth/join";
    }

    @PostMapping("/join")
    public String doJoin() {
        return "auth/join";
    }
}
