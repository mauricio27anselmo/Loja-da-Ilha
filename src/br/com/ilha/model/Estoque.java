package br.com.ilha.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.ilha.enums.Tamanho;

@Entity
@NamedQueries({
	@NamedQuery(name = "Estoque.listarTodos", query = "SELECT estoque FROM Estoque estoque"),
	@NamedQuery(name = "Estoque.pesquisarPorID", query = "SELECT estoque FROM Estoque estoque where estoque.estqID = :ID"),
	@NamedQuery(name = "Estoque.pesquisarPorProdutoP", query = "SELECT estoque FROM Estoque estoque where estoque.estqProduto = :produto AND estoque.estqTamanho = :tamanho"),
	@NamedQuery(name = "Estoque.pesquisarPorProdutoM", query = "SELECT estoque FROM Estoque estoque where estoque.estqProduto = :produto AND estoque.estqTamanho = :tamanho"),
	@NamedQuery(name = "Estoque.pesquisarPorProdutoG", query = "SELECT estoque FROM Estoque estoque where estoque.estqProduto = :produto AND estoque.estqTamanho = :tamanho")
})
@Table(name = "estoque")
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "estq_id")
	private int estqID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estq_produto", referencedColumnName = "prodt_id", nullable = false)
	private Produto estqProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estq_tamanho", length=1, nullable=false)
	private Tamanho estqTamanho;
	
	public int getEstqID() {
		return estqID;
	}
	
	public void setEstqID(int estqID) {
		this.estqID = estqID;
	}
	
	public Produto getEstqProduto() {
		return estqProduto;
	}
	
	public void setEstqProduto(Produto estqProduto) {
		this.estqProduto = estqProduto;
	}
	
	public Tamanho getEstqTamanho() {
		return estqTamanho;
	}
	
	public void setEstqTamanho(Tamanho estqTamanho) {
		this.estqTamanho = estqTamanho;
	}
}
