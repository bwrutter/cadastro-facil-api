package com.api.cadastrofacil.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cadastrofacil.models.RepresentanteModel;


public interface RepresentanteRepository extends JpaRepository<RepresentanteModel, UUID>{

}
