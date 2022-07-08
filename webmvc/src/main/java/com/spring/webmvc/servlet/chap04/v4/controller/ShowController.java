package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.v4.Model;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV4 {
    private final MemberRepository repository
                    = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        List<Member> members = repository.findAll();

//        ModelAndView mv = new ModelAndView("members");
//        mv.addAttribute("mList", members);

        model.addAttribute("mList", members);

        return "members";
    }
}
