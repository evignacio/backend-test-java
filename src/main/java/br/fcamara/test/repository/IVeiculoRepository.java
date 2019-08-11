package br.fcamara.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fcamara.test.domain.Veiculo;

@Repository
public interface IVeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findAll();
}
