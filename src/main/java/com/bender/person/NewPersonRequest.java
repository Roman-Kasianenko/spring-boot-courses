package com.bender.person;

import com.bender.validation.Foo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPersonRequest(
//        @NotEmpty(message = "Name can't be empty") @Foo String name,
        @NotEmpty(message = "Name can't be empty") String name,
        @Min(value = 16, message = "Age must be greater that 16") Integer age,
        @NotNull(message = "Gender can't be empty") Gender gender,
        @Email String email) {

}
