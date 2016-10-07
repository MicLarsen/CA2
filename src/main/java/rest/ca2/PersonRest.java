package rest.ca2;

import Exceptions.GenericInputException;
import Exceptions.NoPersonFoundException;
import JPA.PersonJPA;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import objects.Hobby;
import objects.Person;
import objects.Phone;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("person")
public class PersonRest {

    PersonJPA pjpa;
    Person person;
    Person aPerson;
    List<Person> persons;
    List<Hobby> hobbies;
    List<Phone> phones;
    Gson gsonBuilder;

    @Context
    private UriInfo context;

    public PersonRest() {
        this.pjpa = new PersonJPA();
        this.hobbies = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.gsonBuilder = new GsonBuilder().create();
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Object getPerson(@PathParam("id") int id) {

//        Person person = pjpa.getPersonSimpel(id);
//        if (person == null) {
//            throw new NoPersonFoundException("No person with the requested ID exists.");
//        }
        System.out.println("rest: " + person.getFirstName());
        System.out.println("hello there");
        return this.gsonBuilder.toJson(person);
        
    }

//    /**
//     *
//     * @param id
//     * @return
//     */
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/complete/{id}")
//    public Object getPersonComplete(@PathParam("id") int id) {
//
//        person = pjpa.getPersonFull(id);
//
//        if (person == null) {
//            throw new NoPersonFoundException("No person with the requested ID exists.");
//        }
//        
//        return this.gsonBuilder.toJson(person);
//
//    }
//
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/complete")
//    public Object getPersonsComplete() {
//
//        persons = pjpa.getPersons();
//
//        if (persons == null || persons.size() == 0) {
//
//            throw new NoPersonFoundException("No persons exists in the database.");
//            
//        }
//        
//        return this.gsonBuilder.toJson(persons);
//    }
//
//    /**
//     *
//     * @param zip
//     * @return
//     */
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/zip/{zip}")
//    public Object getPersonFromCity(@PathParam("zip") int zip) {
//
//        persons = pjpa.getPersons(zip);
//        if (persons == null || persons.size() == 0) {
//
//            throw new NoPersonFoundException("No persons with the requested ZIP code.");
//            
//        }
//        
//        return this.gsonBuilder.toJson(persons);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("add")
//    public void addPerson(String newPerson) {
//        
//        Person aPerson = new Gson().fromJson(newPerson, Person.class);
//        
//        if (aPerson.getHobbies() != null) {
//
//            for (int i = 0; i < aPerson.getHobbies().size(); i++) {
//                
//                Hobby h = aPerson.getHobbies().get(i);
//                if (h.getName() == null) {
//                    throw new GenericInputException("Hobby missing name property.");
//                }
//            }
//        }
//
//        if (aPerson.getPhones() != null) {
//            for (int i = 0; i < aPerson.getPhones().size(); i++) {
//                
//                Phone ph = aPerson.getPhones().get(i);
//                
//                if (ph.getNumber() == 0) {
//                    throw new GenericInputException("Phone number property missing number.");
//                }
//
//            }
//        } else {
//            throw new GenericInputException("Missing phone numbers array.");
//        }
//        if (aPerson.getFirstName() == null) {
//            throw new GenericInputException("Missing first name property.");
//        }
//        if (aPerson.getLastName() == null) {
//            throw new GenericInputException("Missing last name property.");
//        }
//        if (aPerson.getEmail() == null) {
//            throw new GenericInputException("Missing e-mail property.");
//        }
//        if (aPerson.getAddress() == null) {
//            throw new GenericInputException("Missing address property.");
//        }
//
//        pjpa.addPerson(aPerson);
//
//    }
//
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("delete")
//    public boolean deletePerson(@QueryParam("id") int id
//    ) {
//
//        boolean isDeleted = true; //= pr.deletePerson(id);
//        if (isDeleted) {
//            return true;
//        } else {
//            //cast Exception 
//            return false;
//        }
//    }
//
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("edit")
//    public Person editPerson(@QueryParam("object") String person,
//            @PathParam("id") int id
//    ) {
//
//
////        fp.editPerson(editedPerson);
//
//        return null;
//    }

}
