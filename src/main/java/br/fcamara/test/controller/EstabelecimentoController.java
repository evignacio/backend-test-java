package br.fcamara.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estabelecimento")
public class EstabelecimentoController {
	
	@GetMapping
	public String GetAll() {
		return "lista todos os estabelecimentos";
	}
}
