package az.spring.demo.scada.controller;

import az.spring.demo.scada.client.ModbusClientService;
import az.spring.demo.scada.model.FlameDetector;
import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class WebSocketController {

    private final ModbusClientService modbusClientService;
    ModbusClient modbusClient;

    private final SimpMessagingTemplate template;


    // Method to handle messages sent from clients to "/app/message"
//    @Scheduled(fixedRate = 1000)
//    public void sendCashboxUpdates() {
//        boolean []barray = new boolean[2];
//        boolean b = modbusClientService.readData(modbusClient);// Məsələn, 1 ID ilə kassa məbləğini alır
//        barray[0] = b;
//        barray[1] = b;
//        System.out.println("elekber: " + barray[0] + " " + barray[1]);
//
//        // Method to broadcast updates periodically
//        template.convertAndSend("/topic/cashbox", barray);
//
//    }
    @MessageMapping("/hello")
    @SendTo("/topic/cashbox")
    public Map<String, boolean []> send() {
        boolean []barray = new boolean[2];
       boolean b = modbusClientService.readData(modbusClient);// Məsələn, 1 ID ilə kassa məbləğini alır
        System.out.println("bur==it address is: "+b);
       barray[0] = b;
        barray[1] = true;
        System.out.println("esrf: " + barray);
        return Collections.singletonMap("message", barray);
    }


//    @MessageExceptionHandler("/chat")
//    @SendTo("/topic/messages")
//    public FlameDetector setAlarm(@Payload FlameDetector flameDetector) {
//        return flameDetector;
//    }
}
