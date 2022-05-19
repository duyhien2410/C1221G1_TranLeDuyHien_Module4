package com.codegym.service.impl;

import com.codegym.model.SmartPhone;
import com.codegym.repository.ISmartPhoneRepository;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return this.smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return this.smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return this.smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        this.smartPhoneRepository.deleteById(id);
    }
}
