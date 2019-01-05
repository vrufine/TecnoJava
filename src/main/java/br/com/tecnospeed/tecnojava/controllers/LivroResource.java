package br.com.tecnospeed.tecnojava.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tecnospeed.tecnojava.models.Livro;
import br.com.tecnospeed.tecnojava.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livroService.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Livro livro = livroService.buscar(id);

		//CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK)/*.cacheControl(cacheControl)*/.body(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		livroService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livroService.atualizar(livro);

		return ResponseEntity.noContent().build();
	}
	/*
	 * @RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	 * public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long
	 * livroId,
	 * 
	 * @RequestBody Comentario comentario) {
	 * 
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * comentario.setUsuario(auth.getName());
	 * 
	 * livrosService.salvarComentario(livroId, comentario);
	 * 
	 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
	 * 
	 * return ResponseEntity.created(uri).build(); }
	 * 
	 * @RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
	 * public ResponseEntity<List<Comentario>> listarComentarios(
	 * 
	 * @PathVariable("id")Long livroId) { List<Comentario> comentarios =
	 * livrosService.listarComentarios(livroId);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(comentarios); }
	 */
}
