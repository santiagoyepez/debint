package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Periodo;

public class TablaPeriodo {
	public static boolean insertar(Periodo p){
		boolean ret = true;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			ret = false;
			System.out.println(e);
		}
		return ret;
	}
	
	public static List<Periodo> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Periodo> query = em.createNamedQuery("Periodo.findAll", Periodo.class);
		return query.getResultList();
	}
	
	public static Periodo consultarPorId(int idPeriodo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Periodo> query = em.createQuery("SELECT p FROM Periodo p WHERE idPeriodo = " + idPeriodo, Periodo.class);
		return query.getSingleResult();
	}
	
	public static void eliminar(int idPeriodo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Periodo.class, idPeriodo));
		em.getTransaction().commit();
		em.close();		
	}

}
