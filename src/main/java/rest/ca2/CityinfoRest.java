/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.ca2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import objects.CityInfo;

/**
 * REST Web Service
 *
 * @author Michael
 */
@Path("cityinfo")
public class CityinfoRest {

    public List<CityInfo> cityInfo;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CityinfoRest
     */
    public CityinfoRest() {
    }

    /**
     * Retrieves representation of an instance of rest.ca2.CityinfoRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("city")
    public Object getCityinfo() {

        Object returnObject = null;

//        cityInfo = getCityInfo();
        for (CityInfo i : cityInfo) {
            if (i.getCity() == null || Integer.toString(i.getZipCode()) == null) {
                //throw new NotFoundException(city)
            }
        }
        if (cityInfo != null) {

            Gson gson = new GsonBuilder().create();

            returnObject = gson.toJson(cityInfo);

        } else {

            //throw new NotFoundException(city);x
        }
        return returnObject;
    }

    /**
     * PUT method for updating or creating an instance of CityinfoRest
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
