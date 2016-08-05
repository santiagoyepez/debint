package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Carrera;
import model.Materia;

public class TablaMateria {
	public static boolean insertar(Materia m){
		boolean ret = true;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			ret = false;
			System.out.println(e);
		}
		return ret;
	}
	
	public static List<Materia> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Materia> query = em.createNamedQuery("Materia.findAll", Materia.class);
		return query.getResultList();
	}
	
	public static Materia consultarPorId(int idMateria){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Materia> query = em.createQuery("SELECT m FROM Materia m WHERE idMateria = " + idMateria, Materia.class);
		return query.getSingleResult();
	}
}
