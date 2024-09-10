package az.spring.demo.scada.services.impl;

import az.spring.demo.scada.model.Pump;
import az.spring.demo.scada.repository.PumpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PumpServiceImp {

    @Autowired
    private final PumpRepository pumpRepository;

    public List<Pump> getAllPumps() {
        return pumpRepository.findAll();
    }

    public Pump savePump(Pump pump) {
        return pumpRepository.save(pump);
    }

    public Pump getPumpById(Long id) {
        return pumpRepository.findById(id).orElse(null);
    }
}
