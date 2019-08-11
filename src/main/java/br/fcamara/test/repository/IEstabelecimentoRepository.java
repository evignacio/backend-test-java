package br.fcamara.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fcamara.test.domain.Estabelecimento;

public interface IEstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	List<Estabelecimento> findAll();
}
