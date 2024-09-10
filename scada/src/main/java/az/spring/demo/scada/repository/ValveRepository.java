package az.spring.demo.scada.repository;

import az.spring.demo.scada.model.Valve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValveRepository extends JpaRepository<Valve, Long> {
}
