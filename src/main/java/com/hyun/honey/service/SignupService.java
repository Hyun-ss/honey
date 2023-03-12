package com.hyun.honey.service;

import com.hyun.honey.domain.dto.member.MemberInsertDTO;

public interface SignupService {
    void save(MemberInsertDTO dto);
}
