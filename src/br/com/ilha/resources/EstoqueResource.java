package br.com.ilha.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ilha.dao.EstoqueDAO;
import br.com.ilha.enums.Tamanho;
import br.com.ilha.model.Estoque;
import br.com.ilha.model.Produto;

public class EstoqueResource {
	@POST
	@Path("/novoproduto.xtml")
	@Produces(MediaType.APPLICATION_XML)
	void gravarNVezes(Produto prodt, Tamanho tam, int vezes){
		Estoque estq = new Estoque();
		EstoqueDAO estqDAO = new EstoqueDAO();
		estq.setEstqProduto(prodt);
		estq.setEstqTamanho(tam);
		for(int i=0; i<vezes; i++){
			estqDAO.incluir(estq);
		}
	}
	
}
