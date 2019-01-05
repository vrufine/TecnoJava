package br.com.tecnospeed.tecnojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecnospeed.tecnojava.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
