package br.fcamara.test.service;

import java.util.List;

import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.dto.RegistroEventosDto;

public interface IRegistroEventoService {

	
	RegistroEventos saveEvento(RegistroEventosDto registroEvento);

	//List<RegistroEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date);
	
	List<RegistroEventosDto> findByEstacionamentoId(Long id);
}
