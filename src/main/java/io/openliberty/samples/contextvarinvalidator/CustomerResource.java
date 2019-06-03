package io.openliberty.samples.contextvarinvalidator;

import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.POST;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@ApplicationPath("/")
@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource extends Application {

    @Context
    private HttpHeaders headers;

    @POST
    
    public Response postCustomer(@Valid Customer pCustomer) {
        System.out.println(pCustomer);
        return Response.ok(pCustomer).build();
    }

    String getHeaderString(String headerName) {
        return headers.getHeaderString(headerName);
    }

    @GET
    public Response test(@QueryParam("country") String country, @QueryParam("phone") String phone) {
        System.out.println("country=" + country + "&phone=" + phone);
        return ClientBuilder.newClient()
                            .target("http://localhost:9080/ContextVarInValidator/customer")
                            .request()
                            .header("COUNTRY", country)
                            .post(Entity.json(new Customer("John Doe", phone)));
    }

    @GET
    @Path("/index")
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return "<html>" +
               "<title>Obtaining HTTP Headers in a Constraint Validator</title>" +
               "<body>" +
               "<h2>Obtaining HTTP Headers in a Constraint Validator</h2>" +
               "<div><a href=\"http://localhost:9080/ContextVarInValidator/customer?country=UK&phone=4407911123456\">Valid UK phone number</a></div>" +
               "<div><a href=\"http://localhost:9080/ContextVarInValidator/customer?country=UK&phone=07911123456\">Invalid UK phone number</a></div>" +
               "<div><a href=\"http://localhost:9080/ContextVarInValidator/customer?country=US&phone=18005551234\">Valid US phone number</a></div>" +
               "<div><a href=\"http://localhost:9080/ContextVarInValidator/customer?country=US&phone=8005551234\">Invalid US phone number</a></div>" +
               "</body>" +
               "</html>";
    }
}