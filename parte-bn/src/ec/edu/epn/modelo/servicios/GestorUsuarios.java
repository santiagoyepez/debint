package ec.edu.epn.modelo.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.modelo.Usuario;
import ec.edu.epn.modelo.Request;

public class GestorUsuarios {
	
	
	public void crearUsuario(Usuario usuario){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
			
	}
	
	public List<Usuario> buscarUsuarios(String nombreBusqueda){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u where u.username like ?", Usuario.class);
		q.setParameter(1, nombreBusqueda + "%");
		
		usuarios = q.getResultList();
		
		return usuarios;
	}
	
	public void actualizarUsuario(Usuario usuario){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
			
	}
	
	public Usuario ingresarUsuario(String username, String password){
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u from Usuario as u where u.username = :username and u.password = :password",Usuario.class).
				setParameter("username", username ).setParameter("password", password);
		return (Usuario)q.getSingleResult();
	}
	
	

	public void crearRequest(Request requesto){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(requesto);
		em.getTransaction().commit();
		em.close();
			
	}
	
	
	
	
	
	

}
