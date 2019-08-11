package br.fcamara.test.service;

import java.time.LocalDateTime;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.domain.Veiculo;

public class EntradaSaida {

	private Long id;
	private Estabelecimento estabelecimento;
	private LocalDateTime entrada = LocalDateTime.now();
	private LocalDateTime saida = LocalDateTime.now();
	private Veiculo veiculo;

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
