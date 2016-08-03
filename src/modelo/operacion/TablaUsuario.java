package modelo.operacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class TablaUsuario {
	public static boolean registrar(Usuario u){
		boolean ret = true;
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
}
