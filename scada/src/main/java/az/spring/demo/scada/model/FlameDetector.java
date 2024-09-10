package az.spring.demo.scada.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@Component
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlameDetector extends Device {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String tagName;
//    private int registerAddress;
//    private int registerValue;
//    private int bitAddress;
//    private boolean highAlarm;
//
    public FlameDetector(String tagName, int registeAddress, int registerValue, int bitAddress, boolean b) {
        super(tagName, registeAddress, registerValue, bitAddress, b);
    }
}
