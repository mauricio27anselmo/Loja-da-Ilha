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
	@NamedQuery(name = "Solicitacao.listarTodos", query = "SELECT solicitacao FROM Solicitacao solicitacao"),
	@NamedQuery(name = "Solicitacao.pesquisarPorID", query = "SELECT solicitacao FROM Solicitacao solicitacao where solicitacao.solctID = :ID"),
})
@Table(name = "solicitacao")
public class Solicitacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "solct_id")
	private int solctID;
	
	@Column(name = "solct_nome", nullable=false)
	private String solctNome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "solct_produto", referencedColumnName = "prodt_id", nullable = false)
	private Produto solctProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "solct_tamanho", length=1, nullable=false)
	private Tamanho solctTamanho;
	
	@Column(name = "solct_qtd", nullable=false)
	private int solctQtd;
	
	public int getSolctID() {
		return solctID;
	}
	
	public void setSolctID(int solctID) {
		this.solctID = solctID;
	}
	
	public String getSolctNome() {
		return solctNome;
	}
	
	public void setSolctNome(String solctNome) {
		this.solctNome = solctNome;
	}
	
	public Produto getSolctProduto() {
		return solctProduto;
	}
	
	public void setSolctProduto(Produto solctProduto) {
		this.solctProduto = solctProduto;
	}
	
	public Tamanho getSolctTamanho() {
		return solctTamanho;
	}
	
	public void setSolctTamanho(Tamanho solctTamanho) {
		this.solctTamanho = solctTamanho;
	}
	
	public int getSolctQtd() {
		return solctQtd;
	}
	
	public void setSolctQtd(int solctQtd) {
		this.solctQtd = solctQtd;
	}
	
};