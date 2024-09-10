package az.spring.demo.scada.services.impl;

import az.spring.demo.scada.model.Valve;
import az.spring.demo.scada.repository.ValveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValveServiceImp {

    @Autowired
    private ValveRepository valveRepository;


    public List<Valve> getAll() {
        return valveRepository.findAll();
    }
    public Valve save(Valve valve) {
        return valveRepository.save(valve);
    }
    public Valve findById(long id) {
        return valveRepository.findById(id).orElse(null);
    }
}
