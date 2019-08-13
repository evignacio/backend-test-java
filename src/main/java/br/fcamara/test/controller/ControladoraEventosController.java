package br.fcamara.test.controller;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.domain.tdo.RegistroEvento;
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

	@PostMapping("/entrada")
	public ResponseEntity<?> saveEntrada(@RequestBody RegistroEvento registroEvento){
		ControladoraEventos controladoraEventosSave = controladoraEventosService.saveEvento(registroEvento);
		
		/*URI uri = uriBuilder.path("/api/controladora/{estabelecimentoId}/{date}").buildAndExpand(controladoraEventosSave.getId(), LocalDateTime.now()).toUri();
		return ResponseEntity ResponseEntity.created(uri).body(controladoraEventosSave)*/
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/saida")
	public ResponseEntity<?> saveSaida(@RequestBody RegistroEvento  registroEvento){
		ControladoraEventos controladoraEventosSave = controladoraEventosService.saveEvento(registroEvento);
		
		return ResponseEntity.ok().build();
	}
}
