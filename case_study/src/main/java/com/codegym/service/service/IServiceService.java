package com.codegym.service.service;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service> findAll(Pageable pageable);
    void create(Service service);
}
