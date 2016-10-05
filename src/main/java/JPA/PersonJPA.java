package JPA;

import RESTfacade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            person = em.find(Person.class, id);
            em.getTransaction().commit();
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
