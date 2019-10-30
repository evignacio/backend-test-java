package br.fcamara.test.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.fcamara.test.domain.entities.Veiculo;
import br.fcamara.test.application.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public List<Veiculo> findAll() {
		return veiculoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Long id){
		Veiculo veiculo = veiculoService.getById(id);
		if(veiculo.getId() > 0)
			return ResponseEntity.ok(veiculo);
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Veiculo> save(@RequestBody @Valid Veiculo veiculo, UriComponentsBuilder uriBuilder) {

		Veiculo veiculoSave = veiculoService.save(veiculo);
		URI uri = uriBuilder.path("/api/veiculo/{id}")
				.buildAndExpand(veiculo.getId())
				.toUri();

		return ResponseEntity.created(uri).body(veiculoSave);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody @Valid Veiculo veiculo) {
		veiculo.setId(id);
		Veiculo veiculoUpdate = veiculoService.update(veiculo);
		
		if (veiculoUpdate.getId() > 0)
			return ResponseEntity.ok(veiculoUpdate);
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(veiculoService.delete(id))
			return ResponseEntity.ok().body("Veiculo excluido com sucesso");
		else
			return ResponseEntity.notFound().build();
	}

}
