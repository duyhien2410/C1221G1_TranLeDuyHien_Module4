package com.codegym.service.contract;

import com.codegym.dto.ICustomerUseService;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void create(Contract contract);

    List<Contract> findAll();

    List<ICustomerUseService> getList();
}
