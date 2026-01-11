package com.atlas.atlasclub.repo;

import com.atlas.atlasclub.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByMemberId(Long memberId);
    List<Booking> findByFacilityId(Long facilityId);
}
