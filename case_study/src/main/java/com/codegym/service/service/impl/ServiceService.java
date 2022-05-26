package com.codegym.service.service.impl;

import com.codegym.repository.service.IServiceRepository;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<com.codegym.model.service.Service> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public void create(com.codegym.model.service.Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public List<com.codegym.model.service.Service> findAll() {
        return this.serviceRepository.findAll();
    }
}
