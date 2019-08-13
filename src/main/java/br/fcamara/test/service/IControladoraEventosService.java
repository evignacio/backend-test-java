package br.fcamara.test.service;

import java.time.LocalDateTime;
import java.util.List;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.domain.tdo.RegistroEvento;

public interface IControladoraEventosService {

	
	ControladoraEventos saveEvento(RegistroEvento registroEvento);

	List<ControladoraEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date);
}
