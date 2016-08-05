package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Categoria;
import model.Recurso;

public class TablaRecurso {
	
	public static boolean insertar(Recurso r){
		boolean ret = true;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
			EntityManager em = emf.createEntityManager(); 
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			ret = false;
			System.out.println(e);
		}
		return ret;
	}
	
	public static List<Recurso> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Recurso> query = em.createNamedQuery("Recurso.findAll", Recurso.class);
		return query.getResultList();
	}
	
	public static Recurso consultarPorId(int idRecurso){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Recurso> query = em.createQuery("SELECT r FROM Recurso r WHERE idRecurso = " + idRecurso, Recurso.class);
		return query.getSingleResult();
	}
	
	public static List<Recurso> consultarPorCategoria(int idCategoria){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Recurso> query = em.createQuery("SELECT r FROM Recurso r WHERE idCategoria = " + idCategoria, Recurso.class);
		return query.getResultList();
	}
	
	public static List<Recurso> consultarPorTitulo(String titulo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Recurso> query = em.createQuery("SELECT r FROM Recurso r WHERE titulo LIKE '%" + titulo + "%'", Recurso.class);
		return query.getResultList();
	}
	
}
