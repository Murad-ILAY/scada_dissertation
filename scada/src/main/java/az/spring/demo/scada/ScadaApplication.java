package az.spring.demo.scada;

import com.ghgande.j2mod.modbus.ModbusException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScadaApplication {
    public static void main(String[] args) throws ModbusException {
//        https://stackoverflow.com/questions/56871906/how-do-i-send-signal-to-modbus-over-tcp-ip-in-java
       SpringApplication.run(ScadaApplication.class,args);


//        ModbusClientService mbcs = new ModbusClientService(new ModbusConfig());
//        WebSocketController wsc = new WebSocketController(mbcs);
//        wsc.send();


//        try
//        {
//            modbusClient.Connect();

//            if(fd_1.manipulateWithBitSet(modbusClient)){
//                System.out.println("zone 0 is activated");
//            }

//            -------------------
//            FlameDetectorService fds = new FlameDetectorService(fd_1);

//            FlameController flameController = new FlameController(fds);
//            flameController.startFlameSimulation(modbusClient);
//            System.out.println("Alarm is: "+ flameController.read(modbusClient));
//            --------------------

//            if(fd_4.startFlameSimulation(modbusClient) && fd_5.startFlameSimulation(modbusClient) && fd_6.startFlameSimulation(modbusClient)){
//                System.out.println("zone 1 is activated");
//            }

//            fd_2.stopFlameSimulation(modbusClient);
//            fd_3.stopFlameSimulation(modbusClient);


//            modbusClient.WriteSingleCoil(0,true);
//            BitSet bs= BitSet.valueOf(new long []{registers[3]});
//            BitSet wr =
//            wr.set(0, value);
//            modbusClient.WriteSingleRegister(1,5);
//            modbusClient.ReadCoils(1,5);
//            modbusClient.WriteSingleCoil(1,false);

//            for (int i = 0; i < 16; i++){
//
////                boolean isSet = bs.get(i);
////                System.out.println(isSet);
////                bs.set(registers[i]);
////                System.out.println(registers[i]);
//
//            }


//            for(int r: registers){
//                System.out.println(Integer.toBinaryString(r));
//                System.out.println(Integer.bitCount(r));;
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                modbusClient.Disconnect();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }



//        SpringApplication.run(ScadaApplication.class, args);

//        int valueFromModbus = 0x0A; // Example value 1010 in binary
//        boolean isThirdBitSet = (valueFromModbus & (4 << 3)) != 0;
//        System.out.println("Third bit is " + (isThirdBitSet ? "set" : "not set"));
    }
}
