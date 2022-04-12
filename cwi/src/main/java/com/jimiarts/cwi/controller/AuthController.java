package com.jimiarts.cwi.controller;

import com.jimiarts.cwi.form.MemberForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    final Logger log = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String doLogin() {
        return "auth/login";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "auth/join";
    }

    @PostMapping("/join")
    public String doJoin(@Validated MemberForm memberForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("memberForm", memberForm);
            return "auth/join";
        }

        model.addAttribute("memberForm", memberForm);
        return "auth/join";
    }
}
