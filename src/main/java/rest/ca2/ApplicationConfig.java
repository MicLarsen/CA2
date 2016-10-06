/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.ca2;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Michael
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(Exceptions.GenericExceptionMapper.class);
        resources.add(Exceptions.NoPersonFoundExceptionMapper.class);
        resources.add(Exceptions.GenericInputExceptionMapper.class);
        resources.add(rest.ca2.CityinfoRest.class);
        resources.add(rest.ca2.CompanyRest.class);
        resources.add(rest.ca2.OtherInfoRest.class);
        resources.add(rest.ca2.PersonRest.class);
    }
    
}