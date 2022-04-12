package com.jimiarts.cwi.form;

import com.jimiarts.cwi.validator.PasswordValueMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordValueMatch.List({
    @PasswordValueMatch(
        field = "password",
        fieldMatch = "passwordConfirmation",
        message = "Passwords do not match!"
    )
})
@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @NotNull
    private String password;

    @NotEmpty(message = "passwordConfirmation cannot be empty")
    @NotNull
    private String passwordConfirmation;
}
