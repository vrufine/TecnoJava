package br.com.tecnospeed.tecnojava.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tecnospeed.tecnojava.models.Autor;
import br.com.tecnospeed.tecnojava.services.AutorService;

@RestController
@RequestMapping(value = "/autor")
public class AutorResource {

	@Autowired
	private AutorService autorService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> autores = autorService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Autor autor) {
		autor = autorService.create(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> buscar(@PathVariable("id") Long id) {
		Autor autor = autorService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}

}