package kopachevsky.calc.services;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/config-context.xml", "classpath:/spring/app-context.xml" })
@ActiveProfiles("test")
public class CalculatorServiceFunctionalTest {

    private static final double DELTA = 0.0001;
    // f1 = 10, 20, 11, 5, 12, 11
    // f2 = 21, 10, 2, 4, 67, 1
    @Autowired
    CalculatorService calculator;

    @Test
    public void test_get() {
        // f2 > 10
        Assert.assertEquals(11.254, calculator.get(0), DELTA);
        // f1 < 10
        Assert.assertEquals(2.4568, calculator.get(2), DELTA);
        // f1 == 10
        Assert.assertEquals(0.3655, calculator.get(1), DELTA);
    }

    @Test
    public void test_post_less_than_ten() {
        // f1[v3]+ v2 < 10
        Assert.assertTrue(calculator.post(2.123, 3, 0));
        Assert.assertEquals(7.323, calculator.get(0), DELTA);
    }

    @Test
    public void test_post_bigger_than_ten() {
        // f1[v3]+ v2 > 10
        Assert.assertFalse(calculator.post(23.221311, 3, 0));
        Assert.assertEquals(18.421311, calculator.get(0), DELTA);
    }
}
