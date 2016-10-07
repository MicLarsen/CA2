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

    public Person getPersonById(int id);
    
    public Person getPersonByPhone(int phoneNum);

    public List<Person> getAllPersonWithHobby(Hobby hobby);

    public List<Person> getPersonsByZip(int zipCode);
    
    public int getHobbyCount(Hobby hobby);
    
    public Person deletePerson(int id);
    
    public Person editPerson(int id);
    
    public boolean addPerson(Person person);

}
