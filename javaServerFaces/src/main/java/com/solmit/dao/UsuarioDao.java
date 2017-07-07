package com.solmit.dao;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.solmit.entidad.Usuario;
import com.solmit.util.HibernateUtil;


@ManagedBean(name = "usuarioDao")
@SessionScoped
public class UsuarioDao{

	Session session = null;

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	
    public Usuario obtenerUsuario(String idUsuario) {
    	session = HibernateUtil.getSessionFactory().openSession();

        return session.get(Usuario.class, idUsuario);  
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
    	session = HibernateUtil.getSessionFactory().openSession();
    
		Query<Usuario> query = session.createQuery("from Usuario");
		return query.getResultList();
	}

	public void eliminar(Usuario usuario) {
    	session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = session.beginTransaction();

		try {
	
			Query q = session.createQuery("delete Usuario   where  idUsuario=:id");
			q.setString("id", usuario.getIdUsuario());	
			  System.out.println(q.executeUpdate());

			transaction.commit();
		} catch (Throwable t) {
			transaction.rollback();
			  throw t;
			}

	}

	public void persistir(Usuario usuario) {
 
		
		session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction(); 
    	session.persist(usuario);
	    session.getTransaction().commit();
	}

	public void actualizar(Usuario usuario) {
    	session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction(); 
		session.merge(usuario);
	    session.getTransaction().commit();
	}

	
	public Usuario validaUser(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = session.beginTransaction();
    	Usuario user=new Usuario();
		try {
	
			Query q = session.createQuery("from Usuario   where  idUsuario=:id  and clave=:password ");
			q.setString("id", usuario.getIdUsuario());	
			q.setString("password", usuario.getClave());	
			
			 user=(Usuario) q.uniqueResult();
			
			System.out.println("dao> "+user);
 
		} catch (Throwable t) {
			transaction.rollback();
			  throw t;
			}
		return user;
	}
	
    @PostConstruct
    private void init(){
    	session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    
	public Long contador() {
		Query query = session.createQuery("SELECT COUNT(*) FROM Usuario");
		Long cont = (Long) query.uniqueResult();
		return cont;

	}

	public Long contador2() {
		Query query = session.createQuery("SELECT  COUNT(*)   FROM Usuario as user WHERE user.idUsuario= :variableid");
		
		Long cont = (Long) query.setString("variableid", "carlos").uniqueResult();
		return cont;

	}
	
	
}
