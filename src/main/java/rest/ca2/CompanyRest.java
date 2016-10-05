/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.ca2;

import JPA.CompanyJPA;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import objects.Company;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("company")
public class CompanyRest {

    @Context
    private UriInfo context;
    CompanyJPA cjpa;

    /**
     * Creates a new instance of CompanyRest
     */
    public CompanyRest() {
        cjpa = new CompanyJPA();
    }

    /**
     * Retrieves representation of an instance of rest.ca2.CompanyRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(Company c) {
        //TODO return proper representation object
        Gson gson = new GsonBuilder().create();
        Object json = gson.toJson(c);
        return json.toString();
    }

    /**
     * PUT method for updating or creating an instance of CompanyRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Company c = new Gson().fromJson(content, Company.class);

    }
    
    
}
