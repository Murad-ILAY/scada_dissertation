package az.spring.demo.scada.client;

import az.spring.demo.scada.config.ModbusConfig;
import az.spring.demo.scada.model.*;
import az.spring.demo.scada.services.impl.FlameDetectorServiceImpl;
import az.spring.demo.scada.services.impl.MeasurementDeviceServiceImp;
import az.spring.demo.scada.services.impl.PumpServiceImp;
import az.spring.demo.scada.services.impl.ValveServiceImp;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ModbusClientService {

    private final ModbusConfig modbusConfig;
    private final FlameDetectorServiceImpl flameDetectorService;
    private final PumpServiceImp pumpServiceImp;
    private final ValveServiceImp valveServiceImp;
    private final MeasurementDeviceServiceImp measurementDeviceServiceImp;

    static List<FlameDetector> flameDetectorList= new ArrayList<>();
    static List<Valve> valveList= new ArrayList<>();
    static List<Pump> pumpList= new ArrayList<>();
    static List<MeasurementDevice> measurementDeviceList= new ArrayList<>();

    BitSet [] bitSet = new BitSet[2];

// Get register value as an bit array
    public BitSet[] getRegisterValueAsBitArray(int registerAddress){
        try {
            int[] registerValues =modbusConfig.getModbusClient().ReadHoldingRegisters(registerAddress,2);
             bitSet [0]  = BitSet.valueOf(new long[] {registerValues[0]});
             bitSet [1]  = BitSet.valueOf(new long[] {registerValues[1]});
            return bitSet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    //    Read all data from modbus, create detectors if not exist and write the read data to this detectors when program is initialized
    @PostConstruct
    public void createAndUpdateFlameDetectors(){

        flameDetectorList= flameDetectorService.getAllUsers();
        valveList = valveServiceImp.getAll();
        pumpList = pumpServiceImp.getAllPumps();
        measurementDeviceList = measurementDeviceServiceImp.getAll();

//        Creat or update value for flame detectors
        if(flameDetectorList.size() !=4){
            for (int i = 0; i < 4; i++) {
                String tagName = "Btf-" + (i + 1);
                FlameDetector fd = new FlameDetector(tagName, 0, 0, i, getRegisterValueAsBitArray(0)[0].get(i));
                flameDetectorList.add(fd);
                flameDetectorService.saveFlameDetector(fd);
            }
        }else{
            updateFlameDetectorsValueContinuously();
        }

//        Create or update value for Valves
        if(valveList.size() !=1){
            String tagName = "Valve-" + (1);
            Valve valve = new Valve(tagName,1,0,0, getRegisterValueAsBitArray(0)[1].get(0));
            valveList.add(valve);
            valveServiceImp.save(valve);
        }
        else {
            updateValveValueContinuously();
        }

//        Create or update value for pumps

//        Create or update value for measurement devices


    }





//     Reading each individual sensor's high alarm state
    public void readSensorValue(int bitAddress,int registerAddress){
        boolean sensorHighAlarm = getRegisterValueAsBitArray(registerAddress)[0].get(bitAddress);
    }

    public boolean[] [] readDataFromAllFlameDetectors() {
        boolean[][] alarmsState = new boolean[2][4];
        try {
             for(int i=0; i<4;i++){
                boolean res = flameDetectorService.getFlameDetectorById(flameDetectorList.get(i).getId()).isHighAlarm();
                alarmsState[0][i]=res;
//                System.out.println("Alarms State is + " + alarmsState[i]);

            }
//             for(int i=0; i<4;i++){
//
//             }
            boolean result = valveServiceImp.findById(valveList.getFirst().getId()).isHighAlarm();
            alarmsState[1][0]=result;
            return alarmsState;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return alarmsState;

    }

//    Update Flame Detector alarm state continuously in every 2 seconds
    @Scheduled(fixedRate = 3000)
    public List<FlameDetector> updateFlameDetectorsValueContinuously(){
        for(int i=0;i<flameDetectorList.size();i++){
            flameDetectorList.get(i).setHighAlarm(getRegisterValueAsBitArray(0)[0].get(i));
            flameDetectorService.saveFlameDetector((FlameDetector) flameDetectorList.get(i));
            System.out.println("Almaaa "+ flameDetectorList.get(i).isHighAlarm());
        }
        return flameDetectorList;
    }

    @Scheduled(fixedRate = 3000)
    public List<Valve> updateValveValueContinuously(){
        for(int i=0;i<valveList.size();i++){
            valveList.get(i).setHighAlarm(getRegisterValueAsBitArray(0)[1].get(i));
            valveServiceImp.save(valveList.get(i));
            System.out.println("Almaaa "+ valveList.get(i).isHighAlarm());
        }
        return valveList;
    }





//    Activation of individual Flame detector
    public boolean activateFireAlarm(int bitAddress) {
        try {
            bitSet[0].set(bitAddress,true);
            long[] longArray =  bitSet[0].toLongArray();
        modbusConfig.getModbusClient().WriteSingleRegister(0,(int) longArray[0]);
        return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //    Deactivation of individual Flame detector
    public boolean deactivateFireAlarm(int bitAddress) {
        try {
            bitSet[0].set(bitAddress,false);
            long[] longArray =  bitSet[0].toLongArray();
            modbusConfig.getModbusClient().WriteSingleRegister(0,(int) longArray[0]);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
