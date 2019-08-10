package br.fcamara.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.teste.service.implementation.VeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	private VeiculoService veiculoService;
	
	@GetMapping
	public  String GetAll() {
		return "Lista toodos os veículos"; 
	}
}
