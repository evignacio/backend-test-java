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

import br.fcamara.test.domain.entities.Estabelecimento;
import br.fcamara.test.application.service.EstabelecimentoService;

@RestController
@RequestMapping("/api/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@GetMapping
	public List<Estabelecimento> GetAll() {
		return estabelecimentoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> findById(@PathVariable Long id) {
		Estabelecimento estabelecimento = estabelecimentoService.findById(id);

		if(estabelecimento.getId() > 0)
			return ResponseEntity.ok().body(estabelecimento);
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Estabelecimento> save(@RequestBody @Valid Estabelecimento estabelecimento, UriComponentsBuilder uriBuilder) {
		Estabelecimento estabelecimentoSave = estabelecimentoService.save(estabelecimento);

		URI uri = uriBuilder.path("/api/estabelecimento/{id}").buildAndExpand(estabelecimentoSave.getId()).toUri();
		return ResponseEntity.created(uri).body(estabelecimentoSave);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Estabelecimento> update(@PathVariable Long id, @RequestBody @Valid Estabelecimento estabelecimento) {
		estabelecimento.setId(id);
		Estabelecimento estabelecimentoUpdate =  estabelecimentoService.update(estabelecimento);

		if(estabelecimentoUpdate.getId() > 0)
			return ResponseEntity.ok(estabelecimentoUpdate);
		else
			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(estabelecimentoService.delete(id))
			return ResponseEntity.ok().body("Estabelecimento excluido com sucesso");

		return ResponseEntity.notFound().build();
	}

}
