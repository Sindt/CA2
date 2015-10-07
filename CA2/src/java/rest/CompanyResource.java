/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Company;
import entity.Person;
import facade.CompanyFacade;
import facade.JSONConvert;
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
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;

    CompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("pu_prod"));

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
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        return Response.ok(JSONConvert.getJSONFromCompany(facade.getCompany(id))).build();
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompany() {
        return JSONConvert.getJSONFromCompany(facade.getCompanys());

    }

    @POST
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveCompany(String company) {
        Company c = JSONConvert.getCompanyFromJson(company);
        c = facade.addCompany(c);
        return JSONConvert.getJSONFromCompany(c);
    }

    @DELETE
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCompany(@PathParam("id") int id) {
        Company c = facade.deleteCompany(id);
        return JSONConvert.getJSONFromCompany(c);
    }
}
