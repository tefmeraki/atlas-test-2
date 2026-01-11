package com.atlas.atlasclub.service;

import com.atlas.atlasclub.dto.CreateMemberRequest;
import com.atlas.atlasclub.entity.ClubMember;
import com.atlas.atlasclub.repo.ClubMemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final ClubMemberRepository memberRepository;

    public MemberService(ClubMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ClubMember create(CreateMemberRequest req) {
        if (req == null || req.fullName == null || req.fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("fullName es obligatorio");
        }
        if (req.email == null || req.email.trim().isEmpty()) {
            throw new IllegalArgumentException("email es obligatorio");
        }
        if (memberRepository.findByEmail(req.email.trim()).isPresent()) {
            throw new IllegalArgumentException("email ya existe");
        }

        ClubMember m = new ClubMember();
        m.setFullName(req.fullName.trim());
        m.setEmail(req.email.trim());
        m.setJoinDate(req.joinDate != null ? req.joinDate : LocalDate.now());
        return memberRepository.save(m);
    }

    public List<ClubMember> list() {
        return memberRepository.findAll();
    }
}
