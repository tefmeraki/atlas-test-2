package com.atlas.atlasclub.service;

import com.atlas.atlasclub.entity.Facility;
import com.atlas.atlasclub.repo.FacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facility> list() {
        return facilityRepository.findAll();
    }
}
