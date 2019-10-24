package br.fcamara.test.service;

import java.util.List;
import java.util.Optional;

import br.fcamara.test.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.domain.Evento;
import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.domain.dto.RegistroEventosDto;
import br.fcamara.test.repository.RegistroEventoRepository;
import br.fcamara.test.repository.VeiculoRepository;

import javax.transaction.Transactional;

@Service
public class RegistroEventoServiceImp implements RegistroEventoService {

	@Autowired
	private RegistroEventoRepository registroEventoRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Override
	public List<RegistroEventosDto> findByEstacionamentoId(Long estabelecimentoId) {
		RegistroEventosDto registroEventosDto = new RegistroEventosDto();
		return registroEventosDto.convert(registroEventoRepository.findByEstabelecimentoId(estabelecimentoId));
	}

	@Transactional
	@Override
	public RegistroEventos saveEvento(RegistroEventosDto registroEventoDto) {

		Optional<Veiculo> veiculoOp = veiculoRepository.findById(registroEventoDto.getVeiculoId());
		Optional<Estabelecimento> estabelecimentoOp = estabelecimentoRepository.findById(registroEventoDto.getEstabelecimentoId());

		if (!veiculoOp.isPresent() || !estabelecimentoOp.isPresent())
			throw new RuntimeException("Veiculo ou estabelecimento não encontrado");

		RegistroEventos ultimoRegistroEvento = registroEventoRepository.findbyEstabelecimentoVeiculoId(registroEventoDto.getEstabelecimentoId(), registroEventoDto.getVeiculoId());

		RegistroEventos registroEventosNovo = new RegistroEventos();
		registroEventosNovo.setVeiculo(veiculoOp.get());
		registroEventosNovo.setEstabelecimento(estabelecimentoOp.get());
		registroEventosNovo.setDateEvento(registroEventoDto.getDateEvento());

		if (ultimoRegistroEvento == null || ultimoRegistroEvento.getEvento() == Evento.saida)
			registroEventosNovo.setEvento(Evento.entrada);
		else
			registroEventosNovo.setEvento(Evento.saida);

		return registroEventoRepository.save(registroEventosNovo);
	}

}
