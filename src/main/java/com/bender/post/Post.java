package com.bender.post;

public record Post(
        Integer id,
        Integer userId,
        String title,
        String body
) {
}