package com.hyun.honey.service.impl;

import com.hyun.honey.domain.dto.member.MemberInsertDTO;
import com.hyun.honey.domain.entity.MemberEntityRepository;
import com.hyun.honey.security.MyRole;
import com.hyun.honey.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceProcess implements SignupService {
    //jpa에서 DAO는 Repository가 수행
    @Autowired
    private MemberEntityRepository memberEntityRepository;
    @Autowired
    private PasswordEncoder pe;
    @Override
    public void save(MemberInsertDTO dto) {
        memberEntityRepository.save(dto.toEntity(pe)
                .addRole(MyRole.USER));
    }
}
