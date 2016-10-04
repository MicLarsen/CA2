package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Michael
 */
public class EManager {
    
    EntityManager em;
    
    public EManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");
        this.em = emf.createEntityManager();
    }
    
    public EntityManager getEntityManager() {
        return this.em;
    }
}
