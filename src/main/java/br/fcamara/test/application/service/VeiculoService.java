package br.fcamara.test.application.service;

import java.util.List;

import br.fcamara.test.domain.entities.Veiculo;

public interface VeiculoService {

	public Veiculo getById(Long id);

	public Veiculo save(Veiculo veiculo);

	public Veiculo update(Veiculo veiculo);

	public List<Veiculo> findAll();
	
	public Boolean delete(Long id);
}
