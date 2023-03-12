package com.hyun.honey.controller;

import com.hyun.honey.domain.dto.member.MemberInsertDTO;
import com.hyun.honey.service.SignupService;
import com.hyun.honey.service.impl.SignupServiceProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    SignupService service;
    @GetMapping("/member/join")
    public String memberJoin(){
        return "member/join";

    }
    @PostMapping("/member/signup")
    public String signup(MemberInsertDTO dto){
        service.save(dto);
        return "redirect:/";

    }

}
