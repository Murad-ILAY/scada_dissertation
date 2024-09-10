package az.spring.demo.scada.repository;

import az.spring.demo.scada.model.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpRepository extends JpaRepository<Pump, Long> {
}
