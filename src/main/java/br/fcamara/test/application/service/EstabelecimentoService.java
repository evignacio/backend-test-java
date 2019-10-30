package br.fcamara.test.application.service;

import java.util.List;

import br.fcamara.test.domain.entities.Estabelecimento;

public interface EstabelecimentoService  {

	Estabelecimento findById(Long id);
	
	List<Estabelecimento> findAll();
	
	Estabelecimento save(Estabelecimento estabelecimento);
	
	Estabelecimento update(Estabelecimento estabelecimento);
	
	Boolean delete(Long id);
	
}
