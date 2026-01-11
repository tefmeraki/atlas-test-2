package com.atlas.club.service;

import com.atlas.club.exception.BadRequestException;
import com.atlas.club.exception.NotFoundException;
import com.atlas.club.model.Socio;
import com.atlas.club.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Socio crear(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new BadRequestException("El nombre del socio es obligatorio.");
        }
        Socio s = new Socio();
        s.setNombre(nombre.trim());
        if (email != null && !email.trim().isEmpty()) {
            s.setEmail(email.trim());
        }
        return socioRepository.save(s);
    }

    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    public Socio obtener(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Socio no encontrado: id=" + id));
    }
}
