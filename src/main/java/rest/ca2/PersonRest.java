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

    //TEMP
    public Person createPerson() {
        hobbies.add(new Hobby("tennis", "plaiying tennis"));
        hobbies.add(new Hobby("tabletennis", "playiong tabletennis"));

        phones.add(new Phone(12121212, "hjem"));
        phones.add(new Phone(12123412, "arbejde"));

//        Address address = new Address("some address", "some info");

//        Person person = new Person("michael", "Larsen", address, hobbies, phones);
        return person;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete/{id}")
    public Object getPersonComplete(@PathParam("id") int id) {

//        Person person = createPerson();
        Person person = pjpa.getPersonFull(id);

        if (person != null) {

            Result res = new Result();

            res.addPerson(person);

            Gson gson = new GsonBuilder().create();

            Object jsonObject = gson.toJson(res);

            return jsonObject;
        } else {
            //cast exception
            return null;
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete")
    public Object getPersonsComplete() {

        persons = pjpa.getPersons();

        if (persons != null) {

            Object jsonObject = JSONConverter.getJSONFromPerson(persons);
            return jsonObject;
        } else {
            //cast Exception
            return null;
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/zip")
    public Object getPersonFromCity(@PathParam("zip") int zip) {

        persons = pjpa.getPersons(zip);
        if (persons != null) {

            Object jsonObject = JSONConverter.getJSONFromPerson(persons);
            return jsonObject;
        } else {
            //cast Exception 
            return null;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addPerson(String newPerson) {

        System.out.println(newPerson);
        Person aPerson = new Gson().fromJson(newPerson, Person.class);
        pjpa.addPerson(aPerson);
//        if (aPerson.getHobbies() != null) {
//
//            for (int i = 0; i < aPerson.getHobbies().size(); i++) {
//                if (aPerson.getHobbies().get(i) == null) {
//                    // throw new NotFoundException(hobby)
//                }
//            }
//        } else {
//            //throw new NotFoundException(hobby)
//        }
//
//        if (aPerson.getPhones() != null) {
//            for (int i = 0; i < aPerson.getPhones().size(); i++) {
//                if (aPerson.getPhones().get(i) == null) {
//                    // throw new NotFoundException(phone)
//                }
//            }
//        } else {
//            //throw new NotFoundException(phone)
//        }
//        if (aPerson.getFirstName() == null) {
//            //throw new NotFoundException(firstname);
//        }
//        if (aPerson.getLastName() == null) {
//            //throw new NotFoundException(lastname);
//        }
//        if (aPerson.getEmail() == null) {
//            //throw new NotFoundException(email);
//        }
//        if (aPerson.getAddress() == null) {
//            //throw new NotFoundException(address);
//        }
//
//        pjpa.addPerson(aPerson);

    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public boolean deletePerson(@QueryParam("id") int id
    ) {

        boolean isDeleted = true; //= pr.deletePerson(id);
        if (isDeleted) {
            return true;
        } else {
            //cast Exception 
            return false;
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("edit")
    public Person editPerson(@QueryParam("object") String person,
            @PathParam("id") int id
    ) {

        Person editedPerson = JSONConverter.getPersonFromJson(person);
//        fp.editPerson(editedPerson);

        return null;
    }

}
