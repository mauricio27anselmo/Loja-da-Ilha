package br.com.ilha.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ilha.model.Produto;
import br.com.ilha.util.HibernateUtil;

public class ProdutoDAO {
	public void incluir(Produto Produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(Produto);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Produto> Produto = null;
		try{
			Query consulta = sessao.getNamedQuery("Produto.listarTodos");
			Produto = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Produto;
	}
	
	public Produto pesquisarPorID(int ID){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Produto Produto = null;
		try{
			Query consulta = sessao.getNamedQuery("Produto.pesquisarPorID");
			consulta.setLong("ID", ID);
			Produto = (Produto) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Produto;
	}
	
	public void remover(Produto Produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(Produto);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	public void editar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			Produto editarProduto = pesquisarPorID(produto.getProdtID());
			editarProduto.setProdtID(produto.getProdtID());
			editarProduto.setProdtNome(produto.getProdtNome());
			editarProduto.setProdtDescricao(produto.getProdtDescricao());
			editarProduto.setProdtPreco(produto.getProdtPreco());
			sessao.update(editarProduto);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
}
