package com.jimiarts.cwi.form;

import javax.validation.constraints.NotEmpty;

public class MemberForm {
    @NotEmpty(message = "username cannot be empty")
    private String username;
}
