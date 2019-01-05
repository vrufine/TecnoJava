package br.com.tecnospeed.tecnojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tecnospeed.tecnojava.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
}
