package br.fcamara.test.service;

import java.util.List;

import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.tdo.RegistroEventoTdo;

public interface IRegistroEventoService {

	
	RegistroEventos saveEvento(RegistroEventoTdo registroEvento);

	//List<RegistroEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date);
	
	List<RegistroEventos> findByEstacionamentoId(Long id);
}
