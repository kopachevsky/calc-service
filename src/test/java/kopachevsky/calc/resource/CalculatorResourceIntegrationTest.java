package kopachevsky.calc.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;
import kopachevsky.calc.test.api.CalculatorGetResponse;
import kopachevsky.calc.test.api.CalculatorPostResponse;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CalculatorResourceIntegrationTest {

    static final double DELTA = 0.0001;
    static final String BASE_PATH = "http://localhost:8080/calc/resources/calculator";

    @Test
    public void test_get_greater_than_ten() {
        assertEquals(11.254, get(0), DELTA);
    }

    @Test
    public void test_get_less_than_ten() {
        assertEquals(2.4568, get(2), DELTA);
    }

    @Test
    public void test_get_equals_to_ten() {
        assertEquals(0.3655, get(1), DELTA);
    }

    @Test
    public void test_post_less_than_ten() {
        Assert.assertTrue(post(2.123, 3, 0));
        Assert.assertEquals(7.323, get(0), DELTA);
    }

    @Test
    public void test_post_gteater_than_ten() {
        Assert.assertFalse(post(23.221311, 3, 0));
        Assert.assertEquals(18.421311, get(0), DELTA);
    }

    private static double get(final int v1) {
        final WebResource r = resource(BASE_PATH + "/get/" + v1);
        return r.accept(MediaType.APPLICATION_XML_TYPE).get(CalculatorGetResponse.class).getValue();
    }

    private static boolean post(final double v2, final int v3, final int v4) {
        final WebResource r = resource(String.format(BASE_PATH + "/post/%f/%s/%s", v2, v3, v4));
        return r.accept(MediaType.APPLICATION_XML_TYPE).get(CalculatorPostResponse.class).getValue();
    }

    private static WebResource resource(final String url) {
        final Client c = Client.create();
        final WebResource r = c.resource(url);
        return r;
    }

}
