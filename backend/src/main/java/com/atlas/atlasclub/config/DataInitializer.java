package com.atlas.atlasclub.config;

import com.atlas.atlasclub.entity.Facility;
import com.atlas.atlasclub.repo.FacilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedFacilities(FacilityRepository facilityRepository) {
        return args -> {
            if (facilityRepository.count() == 0) {
                facilityRepository.save(new Facility("Pista 1", "TENNIS"));
                facilityRepository.save(new Facility("Pista 2", "TENNIS"));
                facilityRepository.save(new Facility("Sala Fitness", "GYM"));
            }
        };
    }
}
