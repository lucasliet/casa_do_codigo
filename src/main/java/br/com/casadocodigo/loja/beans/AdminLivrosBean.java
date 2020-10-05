package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDAO;
import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();

	@Inject
	private LivroDAO livroDAO;
	
	private List<Long> autoresId = new ArrayList<>();
	
	@Inject
	private AutorDAO autorDAO;
	
	@Transactional
	public String salvar() {
		getAutoresId().forEach(autorId -> {			
			livro.getAutores().add(new Autor(autorId));
		});
		
		livroDAO.salvar(livro);
		System.out.println("Livro cadastrado: " + livro);
		FacesContext.getCurrentInstance()
				  	.getExternalContext()
				  	.getFlash()
				  	.setKeepMessages(true);
		FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Livro salvo com sucesso!"));
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores(){
		return autorDAO.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Long> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Long> autoresId) {
		this.autoresId = autoresId;
	}
}
