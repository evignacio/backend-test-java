package br.fcamara.test.service;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.domain.tdo.RegistroEvento;

public interface IControladoraEventosService {

	//List<ControladoraEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date);

	ControladoraEventos saveEvento(RegistroEvento registroEvento);
}
