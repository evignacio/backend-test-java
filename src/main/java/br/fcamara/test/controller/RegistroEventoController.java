package br.fcamara.test.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.fcamara.test.domain.RegistroEventos;
import br.fcamara.test.domain.tdo.RegistroEventoTdo;
import br.fcamara.test.service.IRegistroEventoService;

@ResponseBody
@RestController
@RequestMapping("/api/evento")
public class RegistroEventoController {

	@Autowired
	private IRegistroEventoService controladoraEventosService;

	@GetMapping("/{estabelecimentoId}")
	public List<RegistroEventos> eventos(@PathVariable Long estabelecimentoId) {
		return controladoraEventosService.findByEstacionamentoId(estabelecimentoId);
	}

	@PostMapping
	public ResponseEntity<?> saveEntrada(@RequestBody RegistroEventoTdo registroEvento, UriComponentsBuilder uriBuilder){
		RegistroEventos controladoraEventosSave = controladoraEventosService.saveEvento(registroEvento);
		
		URI uri = uriBuilder.path("/api/evento/{estabelecimentoId}").buildAndExpand(controladoraEventosSave.getId()).toUri();
		return ResponseEntity.created(uri).body(controladoraEventosSave);

	}
}
