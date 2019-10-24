package br.fcamara.test.service;

import java.util.List;

import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.dto.RegistroEventosDto;

public interface RegistroEventoService {

	
	RegistroEventos saveEvento(RegistroEventosDto registroEvento);
	
	List<RegistroEventosDto> findByEstacionamentoId(Long id);
}
