package kopachevsky.calc.test.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CalculatorGetResponse {

    private Double value;

    public CalculatorGetResponse() {
    }

    public CalculatorGetResponse(final Double value) {
        this.value = value;
    }

    @XmlElement
    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

}
