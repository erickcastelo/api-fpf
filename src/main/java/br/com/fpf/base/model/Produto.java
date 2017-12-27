package br.com.fpf.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar dataCompra;
	
	@Column(length=100000000)
	private String image;
	
	private double preco;
	private String origem;
	
	@ManyToOne
	private Categoria categoria;	
	
	public Produto(Long id, String descricao, Calendar dataCompra, String image, double d, String origem,
			Categoria categoria) {
//		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCompra = dataCompra;
		this.image = image;
		this.preco = d;
		this.origem = origem;
		this.categoria = categoria;
	}
	
	public Produto() {
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

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCompra = dataCriacao;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", dataCompra=" + dataCompra + ", image=" + image
				+ ", preco=" + preco + ", origem=" + origem + ", categoria=" + categoria + "]";
	}
	
	public List<Produto> listProdutos(Iterable<Produto> produtos){
		List<Produto> list = new ArrayList<Produto>();
	    if(produtos != null) {
	      for(Produto e: produtos) {
	        list.add(e);
	      }
	    }
	    
	    return list;
	}
	
}
