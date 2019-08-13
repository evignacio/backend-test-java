package br.fcamara.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.domain.Evento;
import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.domain.tdo.RegistroEventoTdo;
import br.fcamara.test.repository.IEstabelecimentoRepository;
import br.fcamara.test.repository.IRegistroEventoRepository;
import br.fcamara.test.repository.IVeiculoRepository;

@Service
public class RegistroEventoService implements IRegistroEventoService {

	@Autowired
	private IRegistroEventoRepository controladoraEventosRepository;

	@Autowired
	private IVeiculoRepository veiculoRepository;

	@Autowired
	private IEstabelecimentoRepository estabelecimentoRepository;

	@Override
	public List<RegistroEventos> findByEstacionamentoId(Long estabelecimentoId) {
		return controladoraEventosRepository.findByEstabelecimentoId(estabelecimentoId);
	}

	@Override
	public RegistroEventos saveEvento(RegistroEventoTdo registroEventoTdo) {
		Optional<Veiculo> veiculoOp = veiculoRepository.findById(registroEventoTdo.getVeiculoId());
		Optional<Estabelecimento> estabelecimentoOp = estabelecimentoRepository
				.findById(registroEventoTdo.getEstabelecimentoId());
		RegistroEventos registroEventos = controladoraEventosRepository
				.findbyEstabelecimentoVeiculoId(registroEventoTdo.getEstabelecimentoId(), registroEventoTdo.getVeiculoId());
		if (!veiculoOp.isPresent() || !estabelecimentoOp.isPresent()) {
			return new RegistroEventos();
		}
		RegistroEventos registroEventosNovo = new RegistroEventos();
		registroEventosNovo.setVeiculo(veiculoOp.get());
		registroEventosNovo.setEstabelecimento(estabelecimentoOp.get());
		registroEventosNovo.setDateEvento(registroEventoTdo.getDateEvento());

		if (registroEventos == null || registroEventos.getEvento() == Evento.saida)
			registroEventosNovo.setEvento(Evento.entrada);
		else
			registroEventosNovo.setEvento(Evento.saida);

		return controladoraEventosRepository.save(registroEventosNovo);
	}

}
