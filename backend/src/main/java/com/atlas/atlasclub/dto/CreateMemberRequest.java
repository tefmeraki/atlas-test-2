package com.atlas.atlasclub.dto;

import java.time.LocalDate;

public class CreateMemberRequest {
    public String fullName;
    public String email;
    public LocalDate joinDate; // opcional
}
