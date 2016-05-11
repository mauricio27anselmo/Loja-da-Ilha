package br.com.ilha.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.com.ilha.dao.EstoqueDAO;
import br.com.ilha.dao.ProdutoDAO;
import br.com.ilha.model.Produto;
import br.com.ilha.enums.Tamanho;

public class ProdutoResource {
	@GET
	@Path("/produtos.xthml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Produto> listarTodos(){
		ProdutoDAO prodtDAO = new ProdutoDAO();
		return prodtDAO.listarTodos();
	}
	
	@GET
	@Path("/produtos.xthml")
	@Produces(MediaType.APPLICATION_XML)
	public int qtdP(Produto prodt){
		EstoqueDAO estqDAO = new EstoqueDAO();
		return estqDAO.pesquisarPorProdutoP(prodt).size(); 
	}
	
	@GET
	@Path("/produtos.xthml")
	@Produces(MediaType.APPLICATION_XML)
	public int qtdM(Produto prodt){
		EstoqueDAO estqDAO = new EstoqueDAO();
		return estqDAO.pesquisarPorProdutoM(prodt).size();	
	}
	
	@GET
	@Path("/produtos.xthml")
	@Produces(MediaType.APPLICATION_XML)
	public int qtdG (Produto prodt){
		EstoqueDAO estqDAO = new EstoqueDAO();
		return estqDAO.pesquisarPorProdutoG(prodt).size();
	}
	
	@POST
	@Path("/novoproduto.xtml")
	@Consumes(MediaType.APPLICATION_XML)
	public void gravar(Produto prodt, int P, int M, int G){
		try{
			ProdutoDAO prodtDAO = new ProdutoDAO();
			EstoqueResource estoqueResource = new EstoqueResource();
			prodtDAO.incluir(prodt);
			estoqueResource.gravarNVezes(prodt, Tamanho.P, P);
			estoqueResource.gravarNVezes(prodt, Tamanho.M, M);
			estoqueResource.gravarNVezes(prodt, Tamanho.G, G);
		}
		catch(Exception e){
			
		}
	}
}
