/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.ca2;

import Exceptions.NoPersonFoundException;
import JPA.PersonJPA;
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
import objects.Person;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("person")
public class PersonRest {

    PersonJPA pjpa;
    List<Person> persons;
    Person person;

    @Context
    private UriInfo context;

    public PersonRest() {
        this.pjpa = new PersonJPA();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getPerson(@PathParam("id") int id) throws NoPersonFoundException {

        Person aPerson = fp.getPerson(id);

        if (aPerson == null) {
            throw new NoPersonFoundException("Person with ID " + id + " not found.");
        }
        String person = "Firstname: " + aPerson.getfName()
                + " Lastname: " + aPerson.getlName()
                + " phone: " + aPerson.getPhone();

        return person;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete/id")
    public Object getPersonComplete() {
        persons = fp.getPersons();
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/complete")
    public Object getPersonsComplete() {
        persons = fp.getPersons();
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/contactinfo")
    public Object getPersonContactInfo() {
        persons = fp.getPersons();
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/contactinfo/id")
    public Object getPersonContactInfoID() {
        persons = fp.getPersons();
        Object jsonObject = JSONConverter.getJSONFromPerson(persons);
        return jsonObject;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addNewPerson(String newPerson) {
        Person aPerson = JSONConverter.getPersonFromJson(newPerson);
        pr.addPerson(aPerson);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public void deletePerson(@QueryParam("id") int id) {
        Person deleted = pr.deletePerson(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("edit")
    public void editPerson(@QueryParam("object") String person, @PathParam("id") int id) {
        Person editedPerson = JSONConverter.getPersonFromJson(person);
        fp.editPerson(editedPerson);
    }

}
