package com.atlas.atlasclub.controller;

import com.atlas.atlasclub.entity.Facility;
import com.atlas.atlasclub.service.FacilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<Facility> list() {
        return facilityService.listFacilities();
    }
}
