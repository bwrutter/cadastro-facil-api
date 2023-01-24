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

import com.api.cadastrofacil.dtos.RepresentanteDto;
import com.api.cadastrofacil.models.RepresentanteModel;
import com.api.cadastrofacil.services.RepresentanteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("/representante")
public class RepresentanteController {

	final RepresentanteService representanteService;
	
	public RepresentanteController (RepresentanteService representanteService) {
		this.representanteService = representanteService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveRepresentante(@RequestBody @Valid RepresentanteDto representanteDto) {
		RepresentanteModel representanteModel = new RepresentanteModel();
		BeanUtils.copyProperties(representanteDto, representanteModel);
		representanteModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(representanteService.save(representanteModel));
	}
	
	@GetMapping
	public ResponseEntity<List<RepresentanteModel>> getAllRepresentante() {
		return ResponseEntity.status(HttpStatus.OK).body(representanteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneRepresentante(@PathVariable(value = "id") UUID id) {
		Optional<RepresentanteModel> representanteModelOptional = representanteService.findById(id);
		if (!representanteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Representante não encontrada!");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(representanteModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneRepresentante(@PathVariable(value = "id") UUID id) {
		Optional<RepresentanteModel> representanteModelOptional = representanteService.findById(id);
		if (!representanteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Representante não encontrada!");
		}		
		representanteService.delete(representanteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRepresentante(@PathVariable(value = "id") UUID id, @RequestBody @Valid RepresentanteDto representanteDto) {
		Optional<RepresentanteModel> representanteModelOptional = representanteService.findById(id);
		if (!representanteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Representante não encontrada!");
		}		
		RepresentanteModel representanteModel = new RepresentanteModel();
		BeanUtils.copyProperties(representanteDto, representanteModel);
		representanteModel.setId(representanteModelOptional.get().getId());
		representanteModel.setDataRegistro(representanteModelOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(representanteService.save(representanteModel));
	}
	
}
