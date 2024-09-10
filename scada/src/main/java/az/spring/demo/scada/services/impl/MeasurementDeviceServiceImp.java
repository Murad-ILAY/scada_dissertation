package az.spring.demo.scada.services.impl;


import az.spring.demo.scada.model.MeasurementDevice;
import az.spring.demo.scada.repository.MeasurementDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementDeviceServiceImp {

    @Autowired
    private final MeasurementDeviceRepository measurementDeviceRepository;


    public List<MeasurementDevice> getAll() {
        return measurementDeviceRepository.findAll();
    }

    public MeasurementDevice findById(Long id) {
        return measurementDeviceRepository.findById(id).orElse(null);
    }
    public MeasurementDevice save(MeasurementDevice measurementDevice) {
        return measurementDeviceRepository.save(measurementDevice);
    }



}
