package br.fcamara.test.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "controladora_eventos")
public class ControladoraEventos {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private Long estabelecimentoId;
	@NotNull
	private Long veiculoId;
	private LocalDateTime dateEntrada;
	private LocalDateTime dateSaida;
	private Evento evento;

	public LocalDateTime getDateEntrada() {
		return dateEntrada;
	}

	public LocalDateTime getDateSaida() {
		return dateSaida;
	}

	public Long getId() {
		return id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public void setDateEntrada(LocalDateTime dateEntrada) {
		this.dateEntrada = dateEntrada;
	}

	public void setDateSaida(LocalDateTime dateSaida) {
		this.dateSaida = dateSaida;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Long estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

}
