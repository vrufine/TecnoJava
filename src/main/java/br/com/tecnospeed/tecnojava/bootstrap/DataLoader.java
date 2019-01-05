package br.com.tecnospeed.tecnojava.bootstrap;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tecnospeed.tecnojava.models.Autor;
import br.com.tecnospeed.tecnojava.models.Livro;
import br.com.tecnospeed.tecnojava.repositories.AutorRepository;
import br.com.tecnospeed.tecnojava.repositories.LivroRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private AutorRepository autorRepo;
	private LivroRepository livroRepo;

	public DataLoader(
		AutorRepository autorRepo,
		LivroRepository livroRepo
	) {
		this.autorRepo = autorRepo;
		this.livroRepo = livroRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		inserirDados();
	}

	private void inserirDados() {
		Autor autor = new Autor();
		autor.setNome("Sir Arthur Conan Doyle");
		autor.setNacionalidade("Brasileiro");
		autor.setNascimento(new Date());
		autorRepo.save(autor);
		
		Livro livro = new Livro();
		livro.setAutor(autor);
		livro.setEditora("Globo");
		livro.setNome("As aventuras de Sherlock Holmes");
		livro.setPublicacao(new Date());
		livro.setResumo("lorem ipsum...");
		livroRepo.save(livro);
	}
	
}
