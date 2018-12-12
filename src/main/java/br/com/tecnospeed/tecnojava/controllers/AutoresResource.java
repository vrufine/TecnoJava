package br.com.tecnospeed.tecnojava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecnospeed.tecnojava.models.Autor;
import br.com.tecnospeed.tecnojava.repositories.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutoresResource {

	@Autowired
	private AutorRepository autorRepository;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<Autor> findById(@PathVariable("id") Long id) {
		return autorRepository.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteById(@PathVariable("id") Long id) {
		autorRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Autor updateById(@PathVariable("id") Long id, @RequestBody Autor novoAutor) {
		novoAutor.setId(id);
		return autorRepository.save(novoAutor);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Autor save(@RequestBody Autor novoAutor) {
		return autorRepository.save(novoAutor);
	}
}
