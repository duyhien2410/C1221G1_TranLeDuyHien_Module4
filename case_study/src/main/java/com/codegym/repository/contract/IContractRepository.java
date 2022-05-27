package com.codegym.repository.contract;

import com.codegym.dto.ICustomerUseService;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select customer.customer_id as customerId," +
            "       customer.customer_name as customerName," +
            "       group_concat(services.service_name) as serviceName" +
            " from contract" +
            "         inner join services on contract.service_id = services.service_id" +
            "         inner join customer on customer.customer_id = contract.customer_id" +
            " group by customer.customer_id", nativeQuery = true)
    List<ICustomerUseService> getList();
}
