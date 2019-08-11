package br.fcamara.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.service.IVeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	private IVeiculoService veiculoService;
	
	@GetMapping
	public  List<Veiculo>  GetAll() {
		return veiculoService.findAll();
	}
}
