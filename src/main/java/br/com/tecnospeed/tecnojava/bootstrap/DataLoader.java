package br.com.tecnospeed.tecnojava.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.tecnospeed.tecnojava.models.Autor;
import br.com.tecnospeed.tecnojava.repositories.AutorRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private AutorRepository autorRepository;

	public DataLoader(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		inserirDados();
	}

	private void inserirDados() {
		Autor autor = new Autor();
		autor.setNome("Vinicius Rufine");
		autorRepository.save(autor);

		Autor autor2 = new Autor();
		autor2.setNome("Galvão Bueno");
		autorRepository.save(autor2);
		
		Autor autor3 = new Autor();
		autor3.setNome("Matias Josias");
		autorRepository.save(autor3);
	}
	
}
