package br.fcamara.test.service;

import java.time.LocalDateTime;

public interface IControladoraEventosService {

	void eventosOnDate(Long estabelecimentoId, LocalDateTime date);

}
