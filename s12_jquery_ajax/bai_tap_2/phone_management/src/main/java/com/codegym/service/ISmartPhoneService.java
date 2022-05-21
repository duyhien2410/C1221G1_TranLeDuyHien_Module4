package com.codegym.service;

import com.codegym.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartPhoneService {
    Page<SmartPhone> findAll(Pageable pageable);

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
