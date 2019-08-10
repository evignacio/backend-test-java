package br.fcamara.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fcamara.teste.domain.Veiculo;

public interface IVeiculoRepository extends JpaRepository<Veiculo, Long> {

}
