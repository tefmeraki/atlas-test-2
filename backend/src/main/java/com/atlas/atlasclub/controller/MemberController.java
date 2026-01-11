package com.atlas.atlasclub.controller;

import com.atlas.atlasclub.dto.CreateMemberRequest;
import com.atlas.atlasclub.entity.ClubMember;
import com.atlas.atlasclub.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<ClubMember> list() {
        return memberService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubMember create(@RequestBody CreateMemberRequest req) {
        return memberService.create(req);
    }
}
