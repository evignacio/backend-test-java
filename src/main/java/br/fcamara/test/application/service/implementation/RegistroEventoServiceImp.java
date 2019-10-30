package br.fcamara.test.application.service.implementation;

import java.util.List;
import java.util.Optional;

import br.fcamara.test.application.service.RegistroEventoService;
import br.fcamara.test.infra.exception.EstabelecimentoException;
import br.fcamara.test.infra.exception.VeiculoException;
import br.fcamara.test.domain.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.entities.Estabelecimento;
import br.fcamara.test.domain.entities.Evento;
import br.fcamara.test.domain.entities.RegistroEventos;
import br.fcamara.test.domain.entities.Veiculo;
import br.fcamara.test.domain.entities.dto.RegistroEventosDto;
import br.fcamara.test.domain.repository.RegistroEventoRepository;
import br.fcamara.test.domain.repository.VeiculoRepository;

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

		if (!veiculoOp.isPresent())
			throw new VeiculoException("Veiculo não encontrado");

		if(!estabelecimentoOp.isPresent())
			throw new EstabelecimentoException("Estabelecimento não encontrado");

		RegistroEventos ultimoRegistroEvento = registroEventoRepository.findLastRegistroEventoVeiculo(registroEventoDto.getEstabelecimentoId(), registroEventoDto.getVeiculoId());

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
