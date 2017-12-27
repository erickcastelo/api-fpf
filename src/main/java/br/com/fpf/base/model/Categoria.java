package br.com.fpf.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable{
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String descricao;	
		
	public Categoria(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria [descricao=" + descricao + "]";
	}

	
	public List<Categoria> listaCategorias(Iterable<Categoria> categorias){
		List<Categoria> list = new ArrayList<Categoria>();
	    if(categorias != null) {
	      for(Categoria c: categorias) {
	        list.add(c);
	      }
	    }
	    
	    return list;
	}
	
}
