package com.atlas.atlasclub.controller;

import com.atlas.atlasclub.dto.CreateBookingRequest;
import com.atlas.atlasclub.entity.Booking;
import com.atlas.atlasclub.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@RequestBody CreateBookingRequest req) {
        return bookingService.createBooking(req);
    }

    @GetMapping
    public List<Booking> list(@RequestParam(required = false) Long memberId) {
        return bookingService.listBookings(memberId);
    }
}
