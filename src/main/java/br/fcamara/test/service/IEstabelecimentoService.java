package br.fcamara.test.service;

import java.util.List;

import br.fcamara.test.domain.Estabelecimento;

public interface IEstabelecimentoService  {

	Estabelecimento findById(Long id);
	
	List<Estabelecimento> findAll();
	
	Estabelecimento save(Estabelecimento estabelecimento);
	
	Estabelecimento update(Estabelecimento estabelecimento);
	
	Boolean delete(Long id);
	
}
