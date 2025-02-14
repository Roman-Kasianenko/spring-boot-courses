package com.bender.person;

public record PersonUpdateRequest(
        String name,
        Integer age
) {
}
