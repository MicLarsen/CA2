package JPA;

import RESTfacade.OtherInfoFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import objects.Address;
import static objects.InfoEntity_.id;
import objects.Person;
import objects.Phone;
import utility.EManager;

/**
 *
 * @author Michael
 */
public class OtherInfoJPA implements OtherInfoFacade {

    EntityManager em;
    Phone phone;
    List<Phone> phones;

    public OtherInfoJPA() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("REST");
        this.em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @Override
    public List<Phone> getPhone(String type, String name) {

        switch (type) {

            case "firstname":
                try {
                    Query query = em.createQuery("SELECT c from Phone c join c.Person p WHERE p.firstName = ?").
                            setParameter(1, name);
                    this.phones = (List<Phone>) query.getResultList();
                    em.getTransaction().commit();
                } finally {
                    em.close();
                }
                break;
            case "lastname":
                try {
                    Query query = em.createQuery("SELECT c from Phone c join c.Person p WHERE p.lastName = ?").
                            setParameter(1, name);
                    this.phones = (List<Phone>) query.getResultList();
                    em.getTransaction().commit();
                } finally {
                    em.close();
                }
                break;
                
            case "company":
                try {
                    Query query = em.createQuery("SELECT c from Phone c join c.Company p WHERE p.name = ?").
                            setParameter(1, name);
                    this.phones = (List<Phone>) query.getResultList();
                    em.getTransaction().commit();
                } finally {
                    em.close();
                }
                break;
            default:
                break;
        }
  
        return phones;
    }

    @Override
    public Address getAddress() {

//        this.em = new EManager();
        return null;
    }

    @Override
    public List<Phone> getPhone(String type, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
