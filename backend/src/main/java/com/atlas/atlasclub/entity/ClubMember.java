package com.atlas.atlasclub.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "club_member")
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    public ClubMember() {}

    public ClubMember(String fullName, String email, LocalDate joinDate) {
        this.fullName = fullName;
        this.email = email;
        this.joinDate = joinDate;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
