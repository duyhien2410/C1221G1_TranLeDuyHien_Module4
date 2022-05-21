package com.codegym.repository;

import com.codegym.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
    Page<SmartPhone> findAll(Pageable pageable);
}
