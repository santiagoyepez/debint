package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Carrera;

public class TablaCarrera {
	public static boolean insertar(Carrera c){
		boolean ret = true;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			ret = false;
			System.out.println(e);
		}
		return ret;
	}
	
	public static List<Carrera> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Carrera> query = em.createNamedQuery("Carrera.findAll", Carrera.class);
		return query.getResultList();
	}
	
	public static Carrera consultarPorId(int idCarrera){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE idCarrera = " + idCarrera, Carrera.class);
		Carrera ret = query.getSingleResult();
		return ret;
	}
}