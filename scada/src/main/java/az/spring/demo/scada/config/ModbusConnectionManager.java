package az.spring.demo.scada.config;

import de.re.easymodbus.modbusclient.ModbusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModbusConnectionManager {

    @Autowired
    private ModbusConfig modbusConfig;
    private boolean isConnected = false;



    public synchronized void connect() {
        if (!isConnected) {
            try {
                modbusConfig.getModbusClient().Connect();
                isConnected = true;
            } catch (Exception e) {
                throw new RuntimeException("Could not connect to Modbus server", e);
            }
        }
    }

    public synchronized void disconnect() {
        if (isConnected) {
            try {
                modbusConfig.getModbusClient().Disconnect();
                isConnected = false;
            } catch (Exception e) {
                throw new RuntimeException("Error disconnecting from Modbus server", e);
            }
        }
    }

    public ModbusClient getClient() {
        return modbusConfig.getModbusClient();
    }
}
