use furama_resort_module_4;

select customer.customer_id                as customerId,
       customer.customer_name              as customerName,
       group_concat(services.service_name) as serviceName
from contract
         inner join services on contract.service_id = services.service_id
         inner join customer on customer.customer_id = contract.customer_id
group by customer.customer_id;

select contract.contract_id,
       (services.service_cost + ifnull((attach_service.attach_service_cost * contract_detail.quantity), 0))
           as contract_total_money_c
from contract
         inner join services on contract.service_id = services.service_id
         inner join contract_detail on contract.contract_id = contract_detail.contract_id
         inner join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id
where contract.contract_id = 2;
