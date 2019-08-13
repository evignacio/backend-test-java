package br.fcamara.test.domain.tdo;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.fcamara.test.domain.Evento;

public class RegistroEvento {

	@NotNull
	private Long estabelecimentoId;
	@NotNull
	private Long veiculoId;
	private LocalDateTime dateEvento = LocalDateTime.now();
	private Evento evento;

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

	public LocalDateTime getDateEvento() {
		return dateEvento;
	}

	public void setDateEvento(LocalDateTime dateEvento) {
		this.dateEvento = dateEvento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
