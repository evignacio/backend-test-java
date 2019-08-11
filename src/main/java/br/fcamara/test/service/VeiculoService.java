package br.fcamara.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.repository.IVeiculoRepository;

@Service
public class VeiculoService implements IVeiculoService {

	@Autowired
	private IVeiculoRepository veiculoRepository;

	@Override
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

}
