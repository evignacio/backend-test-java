package br.fcamara.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fcamara.test.domain.ControladoraEventos;

public interface IControladoraEventos extends JpaRepository<ControladoraEventos, Long> {

}
