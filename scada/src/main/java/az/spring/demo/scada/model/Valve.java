package az.spring.demo.scada.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Valve extends Device{

    public Valve(String tagName, int registeAddress, int registerValue, int bitAddress, boolean b) {
        super(tagName, registeAddress, registerValue, bitAddress, b);
    }
}
