package com.hyun.honey.domain.dto.member;

import com.hyun.honey.domain.entity.MemberEntity;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
public class MemberInsertDTO {
    private String email;
    private String password;
    private String name;
    private String nickName;
    private long phone;

    public MemberEntity toEntity(PasswordEncoder pe){
        return MemberEntity.builder()
                .email(email).password(pe.encode(password)).name(name).nickName(nickName).phone(phone)
                .build();
    }
}
