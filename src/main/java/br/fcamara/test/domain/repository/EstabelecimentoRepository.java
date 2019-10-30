package br.fcamara.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fcamara.test.domain.entities.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

}
