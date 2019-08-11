package br.fcamara.test.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fcamara.test.domain.Veiculo;
import br.fcamara.test.repository.IVeiculoRepository;

@Service
public class VeiculoService implements IVeiculoService {

	@Autowired
	private IVeiculoRepository veiculoRepository;

	public Veiculo getById(Long id) {
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
		if (veiculoOptional.isPresent())
			return veiculoOptional.get();

		return new Veiculo();
	}

	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Transactional
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Transactional
	public Veiculo update(Veiculo veiculo) {
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo.getId());
		if (veiculoOptional.isPresent()) {
			Veiculo veiculoUpdate = veiculoOptional.get();
			veiculoUpdate.setCor(veiculo.getCor());
			veiculoUpdate.setMarca(veiculo.getMarca());
			veiculoUpdate.setPlaca(veiculo.getPlaca());
			veiculoUpdate.setTipo(veiculo.getTipo());
			veiculoUpdate.setModelo(veiculo.getModelo());
			return veiculoUpdate;
		}
		return new Veiculo();
	}

	public Boolean delete(Long id) {
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
		if(veiculoOptional.isPresent())
		{
			veiculoRepository.deleteById(id);
			return true;
		} 
		else
			return false;
	}

}
