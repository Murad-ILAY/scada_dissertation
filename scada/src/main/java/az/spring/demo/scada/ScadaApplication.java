package az.spring.demo.scada;

import az.spring.demo.scada.controller.FlameController;
import az.spring.demo.scada.model.FlameDetector;
import az.spring.demo.scada.services.FlameDetectorService;
import com.ghgande.j2mod.modbus.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScadaApplication {
    public static void main(String[] args) throws ModbusException {
//        https://stackoverflow.com/questions/56871906/how-do-i-send-signal-to-modbus-over-tcp-ip-in-java
        SpringApplication.run(ScadaApplication.class,args);


        ModbusClient modbusClient = new ModbusClient("192.168.100.14", 502);

        FlameDetector fd_1=new FlameDetector("BTF_1",0,0,0,false);
        FlameDetector fd_2=new FlameDetector("BTF_2",0,0,1,false);
        FlameDetector fd_3=new FlameDetector("BTF_3",0,0,2,false);

        FlameDetector fd_4=new FlameDetector("BTF_4",1,0,4,false);
        FlameDetector fd_5=new FlameDetector("BTF_5",1,0,5,false);
        FlameDetector fd_6=new FlameDetector("BTF_6",1,0,6,false);

        try
        {
            modbusClient.Connect();

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

            for (int i = 0; i < 16; i++){

//                boolean isSet = bs.get(i);
//                System.out.println(isSet);
//                bs.set(registers[i]);
//                System.out.println(registers[i]);

            }


//            for(int r: registers){
//                System.out.println(Integer.toBinaryString(r));
//                System.out.println(Integer.bitCount(r));;
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                modbusClient.Disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }
        }



//        SpringApplication.run(ScadaApplication.class, args);

//        int valueFromModbus = 0x0A; // Example value 1010 in binary
//        boolean isThirdBitSet = (valueFromModbus & (4 << 3)) != 0;
//        System.out.println("Third bit is " + (isThirdBitSet ? "set" : "not set"));
    }
}
