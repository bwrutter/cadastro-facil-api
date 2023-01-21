package com.api.cadastrofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadastroFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroFacilApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Aplicação Rodando!";
	}
	
}
