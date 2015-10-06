/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import facade.CompanyFacade;
import facade.JSONConvert;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Sindt
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;

    CompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("pu_test"));

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CompanyResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        return Response.ok(JSONConvert.getJSONFromCompany(facade.getCompany(id))).build();
    }

    /**
     * PUT method for updating or creating an instance of CompanyResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
