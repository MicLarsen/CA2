/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import objects.Person;

/**
 *
 * @author Michael
 */
public class JSONConverter {
    
     public static Person getPersonFromJson(String js) {
        Person person = new Gson().fromJson(js, Person.class);
        return person;
    }

    public static String getJSONFromPerson(Person p) {
        Gson gson = new GsonBuilder().create();
        Object jsonObject = gson.toJson(p);
        return jsonObject.toString();
    }

    public static String getJSONFromPerson(List<Person> persons) {
        Gson gson = new GsonBuilder().create();
        Object jsonObject = gson.toJson(persons);
        return jsonObject.toString();
    }
}
