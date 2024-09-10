package az.spring.demo.scada.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Pump extends Device{

    public Pump(String tagName, int i, int i1, int i2, boolean b) {
        super(tagName, i, i1, i2, b);
    }
}
