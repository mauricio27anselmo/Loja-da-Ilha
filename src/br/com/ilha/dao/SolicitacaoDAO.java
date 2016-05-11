package br.com.ilha.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ilha.model.Solicitacao;
import br.com.ilha.util.HibernateUtil;

public class SolicitacaoDAO {
	public void incluir(Solicitacao Solicitacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(Solicitacao);
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
	public List<Solicitacao> listarTodos(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Solicitacao> Solicitacao = null;
		try{
			Query consulta = sessao.getNamedQuery("Solicitacao.listarTodos");
			Solicitacao = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Solicitacao;
	}
	
	public Solicitacao pesquisarPorID(int ID){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Solicitacao Solicitacao = null;
		try{
			Query consulta = sessao.getNamedQuery("Solicitacao.pesquisarPorID");
			consulta.setLong("ID", ID);
			Solicitacao = (Solicitacao) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return Solicitacao;
	}
	
	public void remover(Solicitacao Solicitacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(Solicitacao);
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
	
	public void editar(Solicitacao solicitacao){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			Solicitacao editarSolicitacao = pesquisarPorID(solicitacao.getSolctID());
			editarSolicitacao.setSolctID(solicitacao.getSolctID());
			editarSolicitacao.setSolctNome(solicitacao.getSolctNome());
			editarSolicitacao.setSolctProduto(solicitacao.getSolctProduto());
			editarSolicitacao.setSolctQtd(solicitacao.getSolctQtd());
			editarSolicitacao.setSolctTamanho(solicitacao.getSolctTamanho());
			sessao.update(editarSolicitacao);
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
