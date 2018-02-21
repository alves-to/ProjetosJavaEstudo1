package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class UsuarioDao {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	public void criptografar(Usuario u) {
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), "cotiinformatica.com.br123456");
		u.setSenha(md5.toHexString());
	}
	
	public void create(Usuario u) {
		criptografar(u);
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
		    	session.save(u);
		    transaction.commit();
		session.close();    
	}
	
	public Usuario findByLogin(Usuario u) {
		criptografar(u);
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery
					("from Usuario u where u.email=:param1 and u.senha=:param2");
			query.setParameter("param1", u.getEmail());
			query.setParameter("param2", u.getSenha());
			Usuario resp = (Usuario) query.uniqueResult();
		session.close();   
		return resp;
	}
	
	public List<Usuario> findByName(Usuario u){
		 session = HibernateUtil.getSessionFactory().openSession();
		     query = session. createQuery("from Usuario u where u.nome=:param1");
		     query.setString("param1", u.getNome());
		 List<Usuario> lista = (List<Usuario>) query.list(); 
		 session.close();
		 return lista;
	}
	
	public Usuario findByCode(Integer cod){
		 session = HibernateUtil.getSessionFactory().openSession();
		     Usuario u = (Usuario) session.get(Usuario.class, cod); 
		 session.close();
		 return u;
	}
	 
	public List<Usuario> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				List<Usuario> resp = session.createCriteria(Usuario.class).list();
			transaction.commit();
		session.close();
		return resp;
	}
	
}
