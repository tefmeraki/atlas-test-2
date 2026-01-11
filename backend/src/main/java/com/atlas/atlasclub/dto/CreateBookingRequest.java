package com.atlas.atlasclub.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateBookingRequest {
    public Long memberId;
    public Long facilityId;
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
}
