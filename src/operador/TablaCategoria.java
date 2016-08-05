package operador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Categoria;

public class TablaCategoria {
	public static boolean insertar(Categoria c){
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
	
	public static List<Categoria> listar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> query = em.createNamedQuery("Categoria.findAll", Categoria.class);
		return query.getResultList();
	}
	
	public static Categoria consultarPorId(int idCategoria){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE idCategoria = " + idCategoria, Categoria.class);
		return query.getSingleResult();
	}
}
