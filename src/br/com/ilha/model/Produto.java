package br.com.ilha.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "Produto.listarTodos", query = "SELECT produto FROM Produto produto"),
	@NamedQuery(name = "Produto.pesquisarPorID", query = "SELECT produto FROM Produto produto where produto.prodtID = :ID")
})
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prodt_id")
	private int prodtID;
	
	@Column(name = "prodt_nome", nullable=false)
	private String prodtNome;
	
	@Column(name = "prodt_preco", precision=8, scale=2, nullable=false)
	private BigDecimal prodtPreco;
	
	@Column(name = "prodt_descricao", nullable=false)
	private String prodtDescricao;
	
	public int getProdtID() {
		return prodtID;
	}
	
	public void setProdtID(int prodtID) {
		this.prodtID = prodtID;
	}
	
	public String getProdtNome() {
		return prodtNome;
	}
	
	public void setProdtNome(String prodtNome) {
		this.prodtNome = prodtNome;
	}
	
	public BigDecimal getProdtPreco() {
		return prodtPreco;
	}
	
	public void setProdtPreco(BigDecimal prodtPreco) {
		this.prodtPreco = prodtPreco;
	}
	
	public String getProdtDescricao() {
		return prodtDescricao;
	}
	
	public void setProdtDescricao(String prodtDescricao) {
		this.prodtDescricao = prodtDescricao;
	}
}
