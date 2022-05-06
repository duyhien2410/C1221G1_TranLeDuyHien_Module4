package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Mercedes",2000000.0,"G63","Germany"));
        productMap.put(2,new Product(2,"Mercedes",2500000.0,"Maybach","Germany"));
        productMap.put(3,new Product(3,"Vinfast",3000000.0,"President","Vietnam"));
    }

    @Override
    public List<Product> productAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        product.setId((int) (Math.random()*1000));
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product:this.productAll()) {
            if ((product.getName().toLowerCase()).contains(name.toLowerCase())){
               productList.add(product);
            }
        }
        return productList;
    }
}
