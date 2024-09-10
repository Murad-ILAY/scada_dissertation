package az.spring.demo.scada.repository;

import az.spring.demo.scada.model.FlameDetector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlameDetectorRepository extends JpaRepository<FlameDetector, Long> {
}
