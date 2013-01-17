package kopachevsky.calc.test.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calculator")
public interface ICalculatorResource {

    @GET
    @Path("/get/{v1}")
    @Produces("application/xml")
    public CalculatorGetResponse get(@PathParam("v1") int v1);

    @GET
    @Path("/post/{v2}/{v3}/{v4}")
    @Produces("application/xml")
    public CalculatorPostResponse post(@PathParam("v2") Double v2, @PathParam("v3") int v3, @PathParam("v4") int v4);

}
