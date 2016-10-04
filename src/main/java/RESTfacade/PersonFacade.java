/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfacade;

import objects.Hobby;
import objects.Person;

/**
 *
 * @author Michael
 */
public interface PersonFacade {
    
    public Person getPerson();
    public Hobby getHobby();
    
}
