package org.example.ss3_thymeleaf_quanlysanpham.service;

import org.example.ss3_thymeleaf_quanlysanpham.model.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);

}
