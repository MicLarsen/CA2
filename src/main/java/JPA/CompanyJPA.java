package JPA;

import RESTfacade.CompanyFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import objects.Address;
import objects.CityInfo;
import objects.Company;
import objects.InfoEntity;
import objects.Phone;

/**
 *
 * @author Michael
 */
public class CompanyJPA implements CompanyFacade {

    EntityManagerFactory emf;

    public CompanyJPA() {
        emf = Persistence.createEntityManagerFactory("CA2");
    }

    @Override
    public Company getCompanyByCVR(int cvr) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        try {

            em.getTransaction().begin();
//            c = em.find(Company.class, cvr);
            Query q = em.createQuery("SELECT c FROM Company c WHERE c.cvr = :cvr", Company.class);
            q.setParameter("cvr", cvr);

            em.getTransaction().commit();
            c = (Company) q.getSingleResult();
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something went wrong");
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public Company getCompanyByPhone(int phone) {
        EntityManager em = emf.createEntityManager();
        Phone p = em.find(Phone.class, phone);

        Query query = em.createNativeQuery("SELECT c.name, c.description, c.cvr, c.numemployees, c.marketvalue FROM Company c WHERE c.id = ?", Company.class);
        query.setParameter(1, p.getInfoEntId());

        List<Company> companies = query.getResultList();
        Company c = companies.get(0);

        return c;

    }

    @Override
    public boolean deleteCompany(int cvr) {
        EntityManager em = emf.createEntityManager();
        try {
            Company c = em.find(Company.class, cvr);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            //Return exception!
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean editCompany(Company comp) {
        EntityManager em = emf.createEntityManager();
        try {
            Company c = em.find(Company.class, comp.getCvr());
            em.getTransaction().begin();
            c.setCvr(comp.getCvr());
            c.setDescription(comp.getDescription());
            c.setMarketValue(comp.getMarketValue());
            c.setName(comp.getName());
            c.setNumEmployees(comp.getNumEmployees());
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            //return exception !!!
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean createCompany(Company comp) {
        EntityManager em = emf.createEntityManager();
        try {
            comp.setEmail("NicklasMolving@gmail.com");
            comp.setAddress(new Address("Hej", "ldsf", new CityInfo(3992, "Slædepatrulje Sirius")));
            em.getTransaction().begin();
            em.persist(comp);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

    }

}
