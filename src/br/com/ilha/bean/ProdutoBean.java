package br.com.ilha.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.ilha.model.Produto;
import br.com.ilha.resources.ProdutoResource;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private ProdutoResource produtoResource;
	private Produto novoProduto;
	private int qtdP;
	private int qtdM;
	private int qtdG;
	private List<Produto> listaProdutos;

	public ProdutoResource getProdutoResource() {
		return produtoResource;
	}

	public void setProdutoResource(ProdutoResource produtoResource) {
		this.produtoResource = produtoResource;
	}
	
	public Produto getNovoProduto() {
		return novoProduto;
	}

	public void setNovoProduto(Produto novoProduto) {
		this.novoProduto = novoProduto;
	}
	
	public int getQtdP() {
		return qtdP;
	}

	public void setQtdP(int qtdP) {
		this.qtdP = qtdP;
	}

	public int getQtdM() {
		return qtdM;
	}

	public void setQtdM(int qtdM) {
		this.qtdM = qtdM;
	}

	public int getQtdG() {
		return qtdG;
	}

	public void setQtdG(int qtdG) {
		this.qtdG = qtdG;
	}

	public List<Produto> getListaProdutos() {
		this.produtoResource = new ProdutoResource();
		return produtoResource.listarTodos();
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
		
	public void gravar(){
		try{
			this.produtoResource = new ProdutoResource();
			produtoResource.gravar(novoProduto, qtdP, qtdM, qtdG);
		}catch(Exception e){
			
		}
	}
	
	public int produtoQtdP(Produto prodt){
		this.produtoResource = new ProdutoResource();
		return produtoResource.qtdP(prodt);
	}
	
	public int produtoQtdM(Produto prodt){
		this.produtoResource = new ProdutoResource();
		return produtoResource.qtdM(prodt);
	}

	public int produtoQtdG(Produto prodt){
		this.produtoResource = new ProdutoResource();
		return produtoResource.qtdG(prodt);
	}
}
