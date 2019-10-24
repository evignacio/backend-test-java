package br.fcamara.test.service;

import java.util.List;

import br.fcamara.test.domain.Veiculo;

public interface VeiculoService {

	public Veiculo getById(Long id);

	public Veiculo save(Veiculo veiculo);

	public Veiculo update(Veiculo veiculo);

	public List<Veiculo> findAll();
	
	public Boolean delete(Long id);
}
