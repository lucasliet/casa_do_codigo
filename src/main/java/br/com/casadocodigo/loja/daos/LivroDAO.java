package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	}

}
