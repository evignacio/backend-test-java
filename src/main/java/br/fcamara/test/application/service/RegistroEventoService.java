package br.fcamara.test.application.service;

import java.util.List;

import br.fcamara.test.domain.entities.RegistroEventos;
import br.fcamara.test.domain.entities.dto.RegistroEventosDto;

public interface RegistroEventoService {

	
	RegistroEventos saveEvento(RegistroEventosDto registroEvento);
	
	List<RegistroEventosDto> findByEstacionamentoId(Long id);
}
