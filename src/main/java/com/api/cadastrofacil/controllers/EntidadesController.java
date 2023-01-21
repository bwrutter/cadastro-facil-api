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

import com.api.cadastrofacil.dtos.EntidadesDto;
import com.api.cadastrofacil.models.EntidadesModel;
import com.api.cadastrofacil.services.EntidadesService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("/entidades")
public class EntidadesController {

	final EntidadesService entidadesService;
	
	public EntidadesController (EntidadesService entidadesService) {
		this.entidadesService = entidadesService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEntidade(@RequestBody @Valid EntidadesDto entidadesDto) {
		EntidadesModel entidadesModel = new EntidadesModel();
		BeanUtils.copyProperties(entidadesDto, entidadesModel);
		entidadesModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadesService.save(entidadesModel));
	}
	
	@GetMapping
	public ResponseEntity<List<EntidadesModel>> getAllEntidade() {
		return ResponseEntity.status(HttpStatus.OK).body(entidadesService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEntidade(@PathVariable(value = "id") UUID id) {
		Optional<EntidadesModel> entidadesModelOptional = entidadesService.findById(id);
		if (!entidadesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidade não encontrada");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(entidadesModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneEntidade(@PathVariable(value = "id") UUID id) {
		Optional<EntidadesModel> entidadesModelOptional = entidadesService.findById(id);
		if (!entidadesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidade não encontrada");
		}		
		entidadesService.delete(entidadesModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEntidade(@PathVariable(value = "id") UUID id, @RequestBody @Valid EntidadesDto entidadesDto) {
		Optional<EntidadesModel> entidadesModelOptional = entidadesService.findById(id);
		if (!entidadesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidade não encontrada");
		}		
		EntidadesModel entidadesModel = new EntidadesModel();
		BeanUtils.copyProperties(entidadesDto, entidadesModel);
		entidadesModel.setId(entidadesModelOptional.get().getId());
		entidadesModel.setDataRegistro(entidadesModelOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(entidadesService.save(entidadesModel));
	}
	
}
