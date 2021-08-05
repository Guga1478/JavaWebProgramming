package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1.estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("andyvieytes");
        contacto.setTelefono("51164808");
        
        //2.estado persistente
        em.getTransaction().begin();
        
        em.persist(contacto);
        
        em.getTransaction().commit();
        
        //3.dettached(separado)
        
        System.out.println("contacto = " + contacto);
    }
    
}
