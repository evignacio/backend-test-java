package br.fcamara.test.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.fcamara.test.domain.Evento;
import br.fcamara.test.domain.RegistroEventos;

public class RegistroEventosDto {

	@NotNull
	private Long estabelecimentoId;
	@NotNull
	private Long veiculoId;
	private LocalDateTime dateEvento = LocalDateTime.now();
	private Evento evento;
	
	public RegistroEventosDto() {
		
	}
	
	public RegistroEventosDto(RegistroEventos registrosEventos) {
		this.estabelecimentoId = registrosEventos.getEstabelecimento().getId();
		this.veiculoId = registrosEventos.getVeiculo().getId();
		this.dateEvento = registrosEventos.getDateEvento();
		this.evento = registrosEventos.getEvento();
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
	
	public List<RegistroEventosDto> convert(List<RegistroEventos> registroEventos){
		return registroEventos.stream().map(RegistroEventosDto::new).collect(Collectors.toList());
	}

}
