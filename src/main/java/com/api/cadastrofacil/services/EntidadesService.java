package com.api.cadastrofacil.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.cadastrofacil.models.EntidadesModel;
import com.api.cadastrofacil.repositories.EntidadesRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class EntidadesService {
	
	final EntidadesRepository entidadesRepository;
	
	public EntidadesService(EntidadesRepository entidadesRepository) {
		this.entidadesRepository = entidadesRepository;
	}

	@Transactional
	public EntidadesModel save(EntidadesModel entidadesModel) {
		return entidadesRepository.save(entidadesModel);
	}
	
	public List<EntidadesModel> findAll() {
		return entidadesRepository.findAll();
	}

	public Optional<EntidadesModel> findById(UUID id) {
		return entidadesRepository.findById(id);
	}

	@Transactional
	public void delete(EntidadesModel entidadesModel) {
		entidadesRepository.delete(entidadesModel);
	}

}
