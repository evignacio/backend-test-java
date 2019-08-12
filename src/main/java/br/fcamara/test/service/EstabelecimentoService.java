package br.fcamara.test.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Estabelecimento;
import br.fcamara.test.repository.IEstabelecimentoRepository;

@Service
public class EstabelecimentoService implements IEstabelecimentoService {

	@Autowired
	private IEstabelecimentoRepository estabelecimentoRepository;

	public List<Estabelecimento> findAll() {
		return estabelecimentoRepository.findAll();
	}

	public Estabelecimento findById(Long id) {
		Optional<Estabelecimento> EstabelecimentoOptional = estabelecimentoRepository.findById(id);
		if (EstabelecimentoOptional.isPresent())
			return EstabelecimentoOptional.get();

		return new Estabelecimento();
	}

	@Transactional
	public Estabelecimento save(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	@Transactional
	public Estabelecimento update(Estabelecimento estabelecimento) {
		Optional<Estabelecimento> EstabelecimentoOptional = estabelecimentoRepository.findById(estabelecimento.getId());
		if (EstabelecimentoOptional.isPresent()) {
			Estabelecimento estabelecimentoUpdate = EstabelecimentoOptional.get();
			estabelecimentoUpdate.setCnpj(estabelecimento.getCnpj());
			estabelecimentoUpdate.setCnpj(estabelecimento.getEndereco());
			estabelecimentoUpdate.setNome(estabelecimento.getNome());
			estabelecimentoUpdate.setQtVagasCarro(estabelecimento.getQtVagasCarro());
			estabelecimentoUpdate.setQtVagasMoto(estabelecimento.getQtVagasMoto());
			return estabelecimentoUpdate;
		}
		return new Estabelecimento();

	}

	@Transactional
	public Boolean delete(Long id) {
		Optional<Estabelecimento> EstabelecimentoOptional = estabelecimentoRepository.findById(id);
		if (EstabelecimentoOptional.isPresent()) {
			estabelecimentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
