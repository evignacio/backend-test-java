package br.fcamara.teste.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import br.fcamara.test.repository.IVeiculoRepository;
import br.fcamara.teste.service.IVeiculoService;

public class VeiculoService implements IVeiculoService{
	
	@Autowired
	private IVeiculoRepository veiculoRepository;

}
