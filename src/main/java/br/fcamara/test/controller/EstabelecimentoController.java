package br.fcamara.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.service.IEstabelecimentoService;

@RestController
@RequestMapping("api/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private IEstabelecimentoService estabelecimentoService;
	
	@GetMapping
	public List<Estabelecimento> GetAll() {
		return estabelecimentoService.findAll();
	}
}
