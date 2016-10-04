/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Result {
    
    private List<Person> persons;
    private String objectType;
    
    public Result(){
    this.persons = new ArrayList<Person>();
    this.objectType = "result";
    }
    
    public void addPerson(Person person) {
        this.persons.add(person);
    }
}
