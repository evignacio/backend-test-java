package br.fcamara.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.repository.IEstabelecimentoRepository;

public class EstabelecimentoService implements IEstabelecimentoService {

	@Autowired
	private IEstabelecimentoRepository estabelecimentorepository;
	
	@Override
	public List<Estabelecimento> findAll() {
		return estabelecimentorepository.findAll();
	}

}
