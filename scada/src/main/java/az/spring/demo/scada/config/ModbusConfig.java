package az.spring.demo.scada.config;

import de.re.easymodbus.modbusclient.ModbusClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModbusConfig {


    @Bean
    public ModbusClient getModbusClient() {
        return new ModbusClient("192.168.0.111", 502);
    }


}
