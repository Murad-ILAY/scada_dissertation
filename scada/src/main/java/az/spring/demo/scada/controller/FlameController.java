//package az.spring.demo.scada.controller;
//
//import az.spring.demo.scada.model.FlameDetector;
//import az.spring.demo.scada.services.impl.FlameDetectorServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FlameController {
//
//    @Autowired
////    private final FlameDetector flameDetector;
////    @Autowired
//    private FlameDetectorServiceImpl flameDetectorService;
//
//    @PostMapping("/startFlameSimulation")
//public void startFlameSimulation(){
//    boolean alarmState = flameDetectorService.activateFireAlarm(flameDetector);
////    Later I will write this value to database
//}
//
//    @PostMapping("/stopFlameSimulation")
//public void stopFlameSimulation(){
//    boolean alarmState = flameDetectorService.deactivateFireAlarm(flameDetector);
//    //    Later I will write this value to database
//}
//
//    @GetMapping("/readFlameSensor")
//public void read(){
//    boolean alarmState =   flameDetectorService.readData(flameDetector);
//    //    Later I will write this value to database
//}
//}
