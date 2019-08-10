package br.fcamara.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.teste.service.IVeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	private IVeiculoService veiculoService;
	
	@GetMapping
	public  String GetAll() {
		return "Lista toodos os veículos"; 
	}
}
