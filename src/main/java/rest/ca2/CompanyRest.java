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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
     * @param cvr
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCVR")
    public String getCompanyByCVR(@PathParam("cvr") int cvr) {
        Company c = cjpa.getCompany(cvr);
        if (c != null) {
            Gson gson = new GsonBuilder().create();
            Object json = gson.toJson(c);
            return json.toString();
        } else {
            //cast exception!!!!!
            return null;
        }
    }

    /**
     * PUT method for updating or creating an instance of CompanyRest
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Company createCompany(String content) {
        Company c = new Gson().fromJson(content, Company.class);
        return c;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Company deleteCompany(String content) {
        Company c = new Gson().fromJson(content, Company.class);
        return c;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Company editCompany(String content) {
        Company c = new Gson().fromJson(content, Company.class);
        return c;
    }
}
