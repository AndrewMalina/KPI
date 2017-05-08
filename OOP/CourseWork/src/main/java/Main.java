import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Dimosik");
        user.setPassword("PIDOR");
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

        em = PersistenceManager.INSTANCE.getEntityManager();
        User user1 = em.find(User.class, 1L);
        System.out.println(user1);
        PersistenceManager.INSTANCE.close();
    }
}
