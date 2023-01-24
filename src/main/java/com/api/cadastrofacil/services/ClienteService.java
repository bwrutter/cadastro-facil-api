package com.api.cadastrofacil.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.cadastrofacil.models.ClienteModel;
import com.api.cadastrofacil.repositories.ClienteRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class ClienteService {
	
	final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public ClienteModel save(ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}
	
	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<ClienteModel> findById(UUID id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public void delete(ClienteModel clienteModel) {
		clienteRepository.delete(clienteModel);
	}

}
