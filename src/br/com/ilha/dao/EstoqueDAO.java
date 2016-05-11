package br.com.ilha.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ilha.enums.Tamanho;
import br.com.ilha.model.Estoque;
import br.com.ilha.model.Produto;
import br.com.ilha.util.HibernateUtil;

public class EstoqueDAO {
	public void incluir(Estoque Estoque){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(Estoque);
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
	public List<Estoque> listarTodos(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Estoque> Estoque = null;
		try{
			Query consulta = sessao.getNamedQuery("Estoque.listarTodos");
			Estoque = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Estoque;
	}
	
	public Estoque pesquisarPorID(int ID){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Estoque Estoque = null;
		try{
			Query consulta = sessao.getNamedQuery("Estoque.pesquisarPorID");
			consulta.setLong("ID", ID);
			Estoque = (Estoque) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Estoque;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> pesquisarPorProdutoP(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Estoque> Estoque = null;
		try{
			Query consulta = sessao.getNamedQuery("Estoque.pesquisarPorProdutoP");
			consulta.setEntity("produto", produto);
			consulta.setString("tamanho", Tamanho.P.toString());
			Estoque = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Estoque;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> pesquisarPorProdutoM(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Estoque> Estoque = null;
		try{
			Query consulta = sessao.getNamedQuery("Estoque.pesquisarPorProdutoM");
			consulta.setEntity("produto", produto);
			consulta.setString("tamanho", Tamanho.M.toString());
			Estoque = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Estoque;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> pesquisarPorProdutoG(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Estoque> Estoque = null;
		try{
			Query consulta = sessao.getNamedQuery("Estoque.pesquisarPorProdutoG");
			consulta.setEntity("produto", produto);
			consulta.setString("tamanho", Tamanho.G.toString());
			Estoque = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Estoque;
	}
	
	public void remover(Estoque Estoque){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(Estoque);
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
	
	public void editar(Estoque estoque){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			Estoque editarEstoque = pesquisarPorID(estoque.getEstqID());
			editarEstoque.setEstqID(estoque.getEstqID());
			editarEstoque.setEstqProduto(estoque.getEstqProduto());
			editarEstoque.setEstqTamanho(estoque.getEstqTamanho());
			sessao.update(editarEstoque);
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
