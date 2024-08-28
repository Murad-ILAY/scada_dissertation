package az.spring.demo.scada.services;

import az.spring.demo.scada.config.ModbusConfig;
import az.spring.demo.scada.config.ModbusConnectionManager;
import az.spring.demo.scada.model.FlameDetector;
import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.BitSet;

@Service
@ComponentScan
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlameDetectorService {

//    private final FlameDetector flameDetector;
    private final ModbusConnectionManager modbusConnectionManager;



    public boolean activateFireAlarm(FlameDetector flameDetector) {
        try {
            int[] registerValues = modbusConnectionManager.getClient().ReadHoldingRegisters(flameDetector.getRegisterAddress(),1);
            flameDetector.setRegisterValue (registerValues[0]);
            int newRegisterValue = flameDetector.getRegisterValue() | (1<<flameDetector.getBitAddress());
            flameDetector.setRegisterValue(newRegisterValue);
            modbusConnectionManager.getClient().WriteSingleRegister(flameDetector.getRegisterAddress(),newRegisterValue);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deactivateFireAlarm(FlameDetector flameDetector) {
        try {
            int[] registerValues = modbusConnectionManager.getClient().ReadHoldingRegisters(flameDetector.getRegisterAddress(),1);
            flameDetector.setRegisterValue (registerValues[0]);
            int newRegisterValue = flameDetector.getRegisterValue() & ~(1 << flameDetector.getBitAddress());
            flameDetector.setRegisterValue(newRegisterValue);
            modbusConnectionManager.getClient().WriteSingleRegister(flameDetector.getRegisterAddress(),newRegisterValue);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void takeALlDetectors(){
        try {
        int[] registerValues = modbusConnectionManager.getClient().ReadHoldingRegisters(0,1);
        FlameDetector [] flameDetectors = new FlameDetector[4];
            BitSet bs = BitSet.valueOf(new long[]{registerValues[0]});
        for (int i = 0; i < flameDetectors.length; i++) {
            flameDetectors[i]=new FlameDetector("Btf-"+i,0,registerValues[0],i,bs.get(i));
            System.out.println(flameDetectors[i]);

        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean manipulateWithBitSet(FlameDetector flameDetector) {
        try {
            int[] registerValues = modbusConnectionManager.getClient().ReadHoldingRegisters(flameDetector.getRegisterAddress(),1);
            flameDetector.setRegisterValue (registerValues[0]);

            BitSet bs = BitSet.valueOf(new long[]{flameDetector.getRegisterValue()});

            bs.set(15,true);
            bs.set(1,true);
            bs.get(1);

//            Convert bitset back to integer
            long[] longArray = bs.toLongArray();
            if(longArray.length>0){
                int newRegisterValue = (int)longArray[0];
                modbusConnectionManager.getClient().WriteSingleRegister(flameDetector.getRegisterAddress(),newRegisterValue);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean readData(FlameDetector flameDetector) {
        try {
            int[] registerValues = modbusConnectionManager.getClient().ReadHoldingRegisters(flameDetector.getRegisterAddress(),1);
            flameDetector.setRegisterValue (registerValues[0]);

            BitSet bs = BitSet.valueOf(new long[]{flameDetector.getRegisterValue()});

            return bs.get(flameDetector.getBitAddress());

        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
