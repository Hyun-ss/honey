package com.hyun.honey.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor//final 필드를 파라미터로 구성하는 생성자
public enum MyRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String role;//getRole()   //ROLE_USER or ROLE_ADMIN
}
