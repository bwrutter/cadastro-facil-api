package com.api.cadastrofacil.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cadastrofacil.dtos.ClienteDto;
import com.api.cadastrofacil.models.ClienteModel;
import com.api.cadastrofacil.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("/cliente")
public class ClienteController {

	final ClienteService clienteService;
	
	public ClienteController (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto) {
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		clienteModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteModel>> getAllCliente() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") UUID id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneCliente(@PathVariable(value = "id") UUID id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrada!");
		}		
		clienteService.delete(clienteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClienteDto clienteDto) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrada!");
		}		
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		clienteModel.setId(clienteModelOptional.get().getId());
		clienteModel.setDataRegistro(clienteModelOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
	}
	
}
