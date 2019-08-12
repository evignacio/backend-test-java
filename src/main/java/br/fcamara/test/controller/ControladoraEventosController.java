package br.fcamara.test.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.service.IControladoraEventosService;

@ResponseBody
@RestController
@RequestMapping("/api/controladora")
public class ControladoraEventosController {

	@Autowired
	private IControladoraEventosService controladoraEventosService;

	@GetMapping("/{estabelecimentoId}/{date}")
	public List<ControladoraEventos> eventos(@PathVariable Long estabelecimentoId, LocalDateTime date) {
		return controladoraEventosService.eventosOnDate(estabelecimentoId, date);
	}
}
