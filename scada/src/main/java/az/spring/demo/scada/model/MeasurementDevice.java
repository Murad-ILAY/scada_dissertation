package az.spring.demo.scada.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class MeasurementDevice extends Device{

    private Long minAnalogValue;
    private Long maxAnalogValue;

    public MeasurementDevice(String tagName, int i, int i1, int i2, boolean b, Long minAnalogValue, Long maxAnalogValue) {
        super(tagName, i, i1, i2, b);
        this.minAnalogValue = minAnalogValue;
        this.maxAnalogValue = maxAnalogValue;
    }


}
