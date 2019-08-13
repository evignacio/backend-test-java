package br.fcamara.test.service;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.domain.Evento;
import br.fcamara.test.domain.tdo.RegistroEvento;
import br.fcamara.test.repository.IControladoraEventosRepository;

@Service
public class ControladoraEventosService implements IControladoraEventosService {

	@Autowired
	private IControladoraEventosRepository controladoraEventosRepository;

	@Override
	public List<ControladoraEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date) {
		return controladoraEventosRepository.eventosInDate(estabelecimentoId, date);
	}

	@Override
	public ControladoraEventos saveEvento(RegistroEvento registroEvento) {
		ControladoraEventos controladoraEventos = controladoraEventosRepository.findbyEstabelecimentoVeiculoId(registroEvento.getEstabelecimentoId(), registroEvento.getVeiculoId());
		ControladoraEventos controladoraEventosNovo = new ControladoraEventos();
		 if (controladoraEventos == null || controladoraEventos.getEvento() == Evento.saida) {
			controladoraEventosNovo.setEstabelecimentoId(registroEvento.getEstabelecimentoId());
			controladoraEventosNovo.setVeiculoId(registroEvento.getVeiculoId());
			controladoraEventosNovo.setDateEntrada(registroEvento.getDateEvento());
			controladoraEventosNovo.setEvento(Evento.entrada);
			return controladoraEventosRepository.save(controladoraEventosNovo);
		} else {
			controladoraEventosNovo.setEstabelecimentoId(registroEvento.getEstabelecimentoId());
			controladoraEventosNovo.setVeiculoId(registroEvento.getVeiculoId());
			controladoraEventosNovo.setDateSaida(registroEvento.getDateEvento());
			controladoraEventosNovo.setEvento(Evento.saida);
			return controladoraEventosRepository.save(controladoraEventosNovo);
		}
	}

}
