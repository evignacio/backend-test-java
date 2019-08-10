package br.fcamara.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fcamara.teste.domain.Estabelecimento;

public interface IEstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

}
