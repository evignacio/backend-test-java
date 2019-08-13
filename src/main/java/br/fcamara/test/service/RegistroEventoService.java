package br.fcamara.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.domain.Evento;
import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.domain.dto.RegistroEventosDto;
import br.fcamara.test.repository.IEstabelecimentoRepository;
import br.fcamara.test.repository.IRegistroEventoRepository;
import br.fcamara.test.repository.IVeiculoRepository;

@Service
public class RegistroEventoService implements IRegistroEventoService {

	@Autowired
	private IRegistroEventoRepository registroEventoRepository;

	@Autowired
	private IVeiculoRepository veiculoRepository;

	@Autowired
	private IEstabelecimentoRepository estabelecimentoRepository;

	@Override
	public List<RegistroEventosDto> findByEstacionamentoId(Long estabelecimentoId) {
		RegistroEventosDto registroEventosDto = new RegistroEventosDto();
		return registroEventosDto.convert(registroEventoRepository.findByEstabelecimentoId(estabelecimentoId));
	}

	@Override
	public RegistroEventos saveEvento(RegistroEventosDto registroEventoDto) {
		Optional<Veiculo> veiculoOp = veiculoRepository.findById(registroEventoDto.getVeiculoId());
		Optional<Estabelecimento> estabelecimentoOp = estabelecimentoRepository
				.findById(registroEventoDto.getEstabelecimentoId());
		RegistroEventos registroEventos = registroEventoRepository
				.findbyEstabelecimentoVeiculoId(registroEventoDto.getEstabelecimentoId(), registroEventoDto.getVeiculoId());
		if (!veiculoOp.isPresent() || !estabelecimentoOp.isPresent()) {
			return new RegistroEventos();
		}
		RegistroEventos registroEventosNovo = new RegistroEventos();
		registroEventosNovo.setVeiculo(veiculoOp.get());
		registroEventosNovo.setEstabelecimento(estabelecimentoOp.get());
		registroEventosNovo.setDateEvento(registroEventoDto.getDateEvento());

		if (registroEventos == null || registroEventos.getEvento() == Evento.saida)
			registroEventosNovo.setEvento(Evento.entrada);
		else
			registroEventosNovo.setEvento(Evento.saida);

		return registroEventoRepository.save(registroEventosNovo);
	}

}
