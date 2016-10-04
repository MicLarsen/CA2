/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfacade;

import java.util.List;
import objects.Hobby;
import objects.Person;

/**
 *
 * @author Michael
 */
public interface PersonFacade {

    public Person getPerson(int id);

    public List<Person> getPersons();

    public List<Person> getPersons(int zipCode);
    
    public Person deletePerson(int id);
    
    public Person editPerson(int id);
    
    public Person addPerson();

}
