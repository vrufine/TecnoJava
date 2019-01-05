package br.com.tecnospeed.tecnojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecnospeed.tecnojava.models.Autor;
import br.com.tecnospeed.tecnojava.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepo;
	
	public List<Autor> getAll() {
		return autorRepo.findAll();
	}	
	
	public Autor create(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autorRepo.findById(autor.getId());
			if(a.isPresent()) {
				throw new RuntimeException("O autor já existe.");
			}
		}
		return autorRepo.save(autor);
	}
	
	public Autor getById(Long id) {
		Optional<Autor> autor = autorRepo.findById(id);
		
		if(!autor.isPresent()) {
			throw new RuntimeException("O autor não pôde ser encontrado.");
		}
		return autor.get();
	}
}
