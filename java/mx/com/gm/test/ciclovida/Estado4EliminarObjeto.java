package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //definimos la variable
        Contacto contacto = null;

        //recuperamos el objeto
        //detachet
        contacto = em.find(Contacto.class, 3);       

        em.getTransaction().begin();

        //remove
        em.remove(em.merge(contacto));

        em.getTransaction().commit();

        //transitivo
        System.out.println("contacto = " + contacto);
    }

}
