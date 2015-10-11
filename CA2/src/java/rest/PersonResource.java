/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import deploy.DeploymentConfiguration;
import entity.Person;
import exceptions.PersonNotFoundException;
import facade.JSONConvert;
import facade.PersonFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Sindt
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));

    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) throws PersonNotFoundException {
        return Response.ok(JSONConvert.getJSONFromPerson(facade.getPerson(id))).build();
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonxx(){
        String pu = DeploymentConfiguration.PU_NAME;
        String json = "{\"d\":\"\"" + pu +" \"}";
        
        
        return Response.ok(json).build();
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson() {
        return JSONConvert.getJSONFromPerson(facade.getPersons());
    }

    @GET
    @Path("test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompletePerson(@PathParam("id") int id) {

        return null;
        //return Response.ok(JSONConvert.getJSONFromPerson(facade.getCompletePerson(id))).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String savePerson(String person) {
        Person p = JSONConvert.getPersonFromJson(person);
        p = facade.addPerson(p);
        return JSONConvert.getJSONFromPerson(p);
    }

    @DELETE
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePerson(@PathParam("id") int id) throws PersonNotFoundException {
        Person p = facade.deletePerson(id);
        return JSONConvert.getJSONFromPerson(p);
    }
}
