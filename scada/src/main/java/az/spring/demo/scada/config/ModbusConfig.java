package az.spring.demo.scada.config;

import de.re.easymodbus.modbusclient.ModbusClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class ModbusConfig {

   @Setter
   @Getter
   private ModbusClient modbusClient;
   private boolean isConnected = false;


    public ModbusConfig(){
        this.modbusClient = new ModbusClient("192.168.1.22", 502);
        connect();
    }

    public synchronized void connect() {
        if (!isConnected) {
            try {
                modbusClient.Connect();
                isConnected = true;
            } catch (Exception e) {
                throw new RuntimeException("Could not connect to Modbus server", e);
            }
        }
    }

    public synchronized void disconnect() {
        if (isConnected) {
            try {
                modbusClient.Disconnect();
                isConnected = false;
            } catch (Exception e) {
                throw new RuntimeException("Error disconnecting from Modbus server", e);
            }
        }
    }


}
