package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SolicitudRecurso;

public class TablaSolicitudRecurso {
	public static boolean insertar(SolicitudRecurso sr){
		boolean ret = true;
		sr.setPuntos(1);
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(sr);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			ret = false;
			System.out.println(e);
		}
		return ret;
	}
	
	public static SolicitudRecurso consultarPorId(int idSolicitudRecurso){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<SolicitudRecurso> query = em.createQuery("SELECT sr FROM SolicitudRecurso sr WHERE idSolicitud = " + idSolicitudRecurso, SolicitudRecurso.class);
		return query.getSingleResult();
	}
	
	public static List<SolicitudRecurso> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<SolicitudRecurso> query = em.createNamedQuery("SolicitudRecurso.findAll", SolicitudRecurso.class);
		return query.getResultList();
	}
}
