package br.fcamara.test.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ControladoraEventos {
	@Id
	@GeneratedValue
	private Long id;
	private Estabelecimento estabelecimento;
	private Veiculo veiculo;
	private LocalDateTime dateEntrada = LocalDateTime.now();
	private LocalDateTime dateSaida = LocalDateTime.now();
	private Evento entrada = Evento.entrada;

	
	public LocalDateTime getDateEntrada() {
		return dateEntrada;
	}

	public LocalDateTime getDateSaida() {
		return dateSaida;
	}


	public Long getId() {
		return id;
	}

	public Evento getEntrada() {
		return entrada;
	}

	public void setEntrada(Evento entrada) {
		this.entrada = entrada;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
