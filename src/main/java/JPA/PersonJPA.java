package JPA;

import RESTfacade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import objects.Address;
import objects.CityInfo;
import objects.Hobby;
import objects.Person;
import objects.Phone;

/**
 *
 * @author Michael
 */
public class PersonJPA implements PersonFacade{

    private Person person;
    private Person aPerson;
    private List<Person> persons;
    private Phone phone;
    private List<Phone> phones;
    private CityInfo cityinfo;
    private Hobby hobby;
    private List<Hobby> hobbies;
    private Address address;
    private EntityManager em;
    private EntityManagerFactory emf;
    
    public PersonJPA() {
        this.emf = Persistence.createEntityManagerFactory("CA2");
        this.em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public Person getPersonFull(int id) {
        try {
            aPerson = em.find(Person.class, id);
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;
    }
    
    @Override
    public Person getPersonSimpel(int id) {
        try {
            aPerson = em.find(Person.class, id);
             Query phonequery = em.createQuery("SELECT u FROM phone u WHERE id = ?").setParameter(1, id);
             this.phones = (List<Phone>) phonequery.getResultList();
             Query hobbyquery = em.createQuery("SELECT u FROM hobby u WHERE id = ?").setParameter(1, id);
             this.hobbies = (List<Hobby>) hobbyquery.getResultList();
             address = em.find(Address.class, id);
            em.getTransaction().commit();
            person = (aPerson.getFirstName()) 
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public List<Person> getPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person deletePerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person editPerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
