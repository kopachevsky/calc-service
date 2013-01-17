package kopachevsky.calc.test.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CalculatorPostResponse {

    private Boolean value;

    public CalculatorPostResponse() {
    }

    public CalculatorPostResponse(final Boolean value) {
        this.value = value;
    }

    @XmlElement
    public Boolean getValue() {
        return value;
    }

    public void setValue(final Boolean value) {
        this.value = value;
    }

}
