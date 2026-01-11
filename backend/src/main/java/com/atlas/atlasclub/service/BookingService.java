package com.atlas.atlasclub.service;

import com.atlas.atlasclub.dto.CreateBookingRequest;
import com.atlas.atlasclub.entity.Booking;
import com.atlas.atlasclub.entity.ClubMember;
import com.atlas.atlasclub.entity.Facility;
import com.atlas.atlasclub.repo.BookingRepository;
import com.atlas.atlasclub.repo.ClubMemberRepository;
import com.atlas.atlasclub.repo.FacilityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClubMemberRepository memberRepository;
    private final FacilityRepository facilityRepository;

    public BookingService(BookingRepository bookingRepository,
                          ClubMemberRepository memberRepository,
                          FacilityRepository facilityRepository) {
        this.bookingRepository = bookingRepository;
        this.memberRepository = memberRepository;
        this.facilityRepository = facilityRepository;
    }

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> listByMember(Long memberId) {
        return bookingRepository.findByMemberId(memberId);
    }

    public Booking create(CreateBookingRequest req) {
        if (req == null) throw new IllegalArgumentException("Body requerido");
        if (req.memberId == null) throw new IllegalArgumentException("memberId requerido");
        if (req.facilityId == null) throw new IllegalArgumentException("facilityId requerido");
        if (req.date == null) throw new IllegalArgumentException("date requerido");
        if (req.startTime == null) throw new IllegalArgumentException("startTime requerido");
        if (req.endTime == null) throw new IllegalArgumentException("endTime requerido");

        LocalTime start = req.startTime;
        LocalTime end = req.endTime;
        if (!end.isAfter(start)) throw new IllegalArgumentException("endTime debe ser posterior a startTime");

        ClubMember member = memberRepository.findById(req.memberId)
                .orElseThrow(() -> new IllegalArgumentException("memberId no existe"));
        Facility facility = facilityRepository.findById(req.facilityId)
                .orElseThrow(() -> new IllegalArgumentException("facilityId no existe"));

        // Regla simple: evitar solapes en la misma instalación y fecha.
        List<Booking> sameSlot = bookingRepository.findByFacilityIdAndDate(req.facilityId, req.date);
        for (Booking b : sameSlot) {
            boolean overlaps = start.isBefore(b.getEndTime()) && end.isAfter(b.getStartTime());
            if (overlaps) {
                throw new IllegalArgumentException("La instalación ya tiene una reserva que solapa en ese horario");
            }
        }

        Booking booking = new Booking();
        booking.setMember(member);
        booking.setFacility(facility);
        booking.setDate(req.date);
        booking.setStartTime(start);
        booking.setEndTime(end);

        return bookingRepository.save(booking);
    }
}
