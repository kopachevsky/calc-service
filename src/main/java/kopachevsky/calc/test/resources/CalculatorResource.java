package kopachevsky.calc.test.resources;

import kopachevsky.calc.services.CalculatorService;
import kopachevsky.calc.test.api.CalculatorGetResponse;
import kopachevsky.calc.test.api.CalculatorPostResponse;
import kopachevsky.calc.test.api.ICalculatorResource;

public class CalculatorResource implements ICalculatorResource {

    private final CalculatorService service;

    public CalculatorResource(final CalculatorService service) {
        super();
        this.service = service;
    }

    @Override
    public CalculatorGetResponse get(final int v1) {
        return new CalculatorGetResponse(service.get(v1));
    }

    @Override
    public CalculatorPostResponse post(final Double v2, final int v3, final int v4) {
        return new CalculatorPostResponse(service.post(v2, v3, v4));
    }

}
