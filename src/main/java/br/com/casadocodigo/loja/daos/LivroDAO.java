package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> listar() {
		return entityManager.createQuery(
				"SELECT DISTINCT(l) FROM Livro l "
			  + "JOIN FETCH l.autores",
				Livro.class
			).getResultList();
	}

}
