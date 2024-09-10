package az.spring.demo.scada.repository;

import az.spring.demo.scada.model.MeasurementDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementDeviceRepository extends JpaRepository<MeasurementDevice, Long> {
}
