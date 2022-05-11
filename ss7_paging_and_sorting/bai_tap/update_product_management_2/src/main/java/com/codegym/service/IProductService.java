package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllAndSearch(String name, String description, String manufacture, Pageable pageable);

    void save(Product product);

    void deleteById(int id);

    Product findById(int id);
}
