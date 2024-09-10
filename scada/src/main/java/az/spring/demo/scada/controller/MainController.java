package az.spring.demo.scada.controller;

import az.spring.demo.scada.client.ModbusClientService;
import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {




    private final ModbusClientService modbusClientService;
    ModbusClient modbusClient = new ModbusClient("192.168.0.111", 502);

    private final SimpMessagingTemplate template;

    @GetMapping
    public boolean [] sendCashboxUpdates() {
        boolean []barray = new boolean[2];
//        boolean b = modbusClientService.readData(modbusClient);// Məsələn, 1 ID ilə kassa məbləğini alır
//        barray[0] = b;
//        barray[1] = b;
        System.out.println("elekber: " + barray[0] + " " + barray[1]);

        //template.convertAndSend("/topic/cashbox", barray);

        return barray;

    }

    public String sayHello(){
        return "Hello World!";
    }



}
