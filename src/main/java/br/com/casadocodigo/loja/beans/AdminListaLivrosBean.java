package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model //@Named e @RequestScoped alias
public class AdminListaLivrosBean {
	private List<Livro> livros = new ArrayList<>();
	
	@Inject
	private LivroDAO dao;
	
	@Transactional
	public List<Livro> getLivros() {
		this.livros = dao.listar();
		return livros;
	}
}
