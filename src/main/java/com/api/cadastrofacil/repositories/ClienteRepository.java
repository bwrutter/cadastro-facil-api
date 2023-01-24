package com.api.cadastrofacil.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cadastrofacil.models.ClienteModel;


public interface ClienteRepository extends JpaRepository<ClienteModel, UUID>{

}
