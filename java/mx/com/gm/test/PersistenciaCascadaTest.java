package mx.com.gm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class PersistenciaCascadaTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Ramon Falcon");
        domicilio.setNroCalle("4069");
        domicilio.setPais("Argentina");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("marielabueno");
        contacto.setTelefono("1151164711");
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Mariela");
        alumno.setApellido("Bueno");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("alumno = " + alumno);
    }
    
}
