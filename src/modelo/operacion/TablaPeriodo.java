package modelo.operacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Periodo;

public class TablaPeriodo {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
	EntityManager em = emf.createEntityManager(); 
	
	public List<Periodo> buscarPeriodos(){
		
		//El name del archivo persistence .xml de META-INF
		
		
		//<persistence-unit name="PruebaJPA" transaction-type="RESOURCE_LOCAL">
		
		//Permite hacer instert, update, delete
		
		
		//Query q = em.createQuery("select p from Periodo p", Periodo.class);
		
		 TypedQuery<Periodo> query =
			      em.createNamedQuery("Periodo.findAll", Periodo.class);
			  List<Periodo> periodosRecibidos = query.getResultList();
			  
		/*
		Query q = em.createQuery("select * from Periodo where l.nombre like ?", Periodo.class);
		q.setParameter(1, nombreBusqueda+"%"); //1 es para el primer signo de interrogacion
		*/

		return periodosRecibidos;
	}
	
	public void eliminarPeriodo(int idRecibido){
		
		Periodo periodoParaEliminar = em.find(Periodo.class, idRecibido);
		
		  em.getTransaction().begin();
		  em.remove(periodoParaEliminar);
		  em.getTransaction().commit();
		  em.close();		
	}
	
	public void agregarPeriodo(Periodo periodoRecibido){
		em.getTransaction().begin();
		em.persist(periodoRecibido); //Sabe automaticamente que tiene que guardar la información en la tabla
		em.getTransaction().commit();
		em.close();
	}
}
