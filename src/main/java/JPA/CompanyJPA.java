package JPA;

import RESTfacade.CompanyFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objects.Company;

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
    public Company getCompany(int cvr) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        try {

            em.getTransaction().begin();
            c = em.find(Company.class, cvr);
            em.getTransaction().commit();
            return c;

        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally{
            em.close();
        }
    }

    @Override
    public boolean deleteCompany(int cvr) {
        EntityManager em = emf.createEntityManager();
        try{
            Company c = em.find(Company.class, cvr);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
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
        try{
            Company c = em.find(Company.class, comp.getCvr());
            em.getTransaction().begin();
            c.setCvr(comp.getCvr());
            c.setDescription(comp.getDescription());
            c.setMarketValue(comp.getMarketValue());
            c.setName(comp.getName());
            c.setNumEmployees(comp.getNumEmployees());
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e){
            em.getTransaction().rollback();
            //return exception !!!
            return false;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean createCompany(Company comp){
        EntityManager em = emf.createEntityManager();
        try{
            
            em.getTransaction().begin();
            em.persist(comp);
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e){
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        
    }

}
