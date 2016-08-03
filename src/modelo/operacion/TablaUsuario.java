package modelo.operacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
