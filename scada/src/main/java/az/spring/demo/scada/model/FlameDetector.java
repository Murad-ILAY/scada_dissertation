package az.spring.demo.scada.model;

import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.BitSet;
@Data
@AllArgsConstructor
@Component
public class FlameDetector {

    private String tagName;
    private int registerAddress;
    private int registerValue;
    private int bitAddress;
    private boolean highAlarm;



}
