package rest.ca2;

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
import objects.Address;
import objects.Hobby;
import objects.Person;
import objects.Phone;
import objects.Result;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("person")
public class PersonRest {

    PersonJPA pjpa;
    Person person;
    List<Person> persons;
    List<Hobby> hobbies;
    List<Phone> phones;

    @Context
    private UriInfo context;

    public PersonRest() {
        this.pjpa = new PersonJPA();
        this.hobbies = new ArrayList<Hobby>();
        this.phones = new ArrayList<Phone>();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Object getPerson(@PathParam("id") int id) {
        
        Person person = new Person("michael", "Larsen");
        
        Result res = new Result();

        res.addPerson(person);

        Gson gson = new GsonBuilder().create();

        Object jsonObject = gson.toJson(res);

        return jsonObject;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete/{id}")
    public Object getPersonComplete(@PathParam("id") int id) {
        hobbies.add(new Hobby("tennis","plaiying tennis"));
        hobbies.add(new Hobby("tabletennis", "playiong tabletennis"));
        
        phones.add(new Phone(12121212, "hjem"));
        phones.add(new Phone(12123412, "arbejde"));  
        
        Address address = new Address("some address" , "some info");
        
        Person person = new Person("michael", "Larsen",  address , hobbies, phones);
        
        Result res = new Result();

        res.addPerson(person);

        Gson gson = new GsonBuilder().create();

        Object jsonObject = gson.toJson(res);

        return jsonObject;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete")
    public Object getPersonsComplete() {
//        persons = fp.getPersons();
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/city")
    public Object getPersonFromCity(@PathParam("city") String city) {
//        persons = fp.getPersonFromCity(city);
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addPerson(String newPerson) {
        Person aPerson = JSONConverter.getPersonFromJson(newPerson);
//        pr.addPerson(aPerson);
    }

    
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public void deletePerson(@QueryParam("id") int id) {
//        Person deleted = pr.deletePerson(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("edit")
    public void editPerson(@QueryParam("object") String person, @PathParam("id") int id) {
        Person editedPerson = JSONConverter.getPersonFromJson(person);
//        fp.editPerson(editedPerson);
    }

}
