package com.codegym.service.service.impl;

import com.codegym.repository.service.IServiceRepository;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
