package az.spring.demo.scada.client;

import az.spring.demo.scada.model.FlameDetector;
import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.BitSet;

@RequiredArgsConstructor
@Service
public class ModbusClientService {



    FlameDetector flameDetector=new FlameDetector("BTF_1",0,0,0,false);
    FlameDetector fd_2=new FlameDetector("BTF_2",0,0,1,false);
//    FlameDetector fd_3=new FlameDetector("BTF_3",0,0,2,false);
//    FlameDetector fd_4=new FlameDetector("BTF_4",1,0,4,false);
//    FlameDetector fd_5=new FlameDetector("BTF_5",1,0,5,false);
//    FlameDetector fd_6=new FlameDetector("BTF_6",1,0,6,false);

    public boolean readData(ModbusClient modbusClient) {

        try {
            modbusClient.Connect();
            int[] registerValues = modbusClient.ReadHoldingRegisters(flameDetector.getRegisterAddress(),1);
//            flameDetector.setRegisterValue (registerValues[0]);

            BitSet bs = BitSet.valueOf(new long[]{flameDetector.getRegisterValue()});

            return bs.get(flameDetector.getBitAddress());

        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
