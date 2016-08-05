package operador;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class TablaUsuario {
	public static boolean registrar(Usuario u){
		boolean ret = true;
		u.setFechaRegistro(new GregorianCalendar().getTime());
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}
	
	public static List<Usuario> consultarPorAlias(String alias){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE alias LIKE '%" + alias + "%'", Usuario.class);
		List<Usuario> ret = query.getResultList();
		return ret;
	}
	
	public static Usuario consultarPorId(int idUsuario){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE idUsuario = " + idUsuario, Usuario.class);
		Usuario ret = query.getSingleResult();
		return ret;
	}
}
