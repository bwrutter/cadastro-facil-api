package com.api.cadastrofacil.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.cadastrofacil.models.RepresentanteModel;
import com.api.cadastrofacil.repositories.RepresentanteRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class RepresentanteService {
	
	final RepresentanteRepository representanteRepository;
	
	public RepresentanteService(RepresentanteRepository representanteRepository) {
		this.representanteRepository = representanteRepository;
	}

	@Transactional
	public RepresentanteModel save(RepresentanteModel representanteModel) {
		return representanteRepository.save(representanteModel);
	}
	
	public List<RepresentanteModel> findAll() {
		return representanteRepository.findAll();
	}

	public Optional<RepresentanteModel> findById(UUID id) {
		return representanteRepository.findById(id);
	}

	@Transactional
	public void delete(RepresentanteModel representanteModel) {
		representanteRepository.delete(representanteModel);
	}

}
