package com.atlas.atlasclub.repo;

import com.atlas.atlasclub.entity.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
    Optional<ClubMember> findByEmail(String email);
}
