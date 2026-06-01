package org.example.ss3_thymeleaf_quanlysanpham.service;

import org.example.ss3_thymeleaf_quanlysanpham.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static final Map<Long, Product> products = new HashMap<>();

    static {

        products.put(1L,
                new Product(
                        1L,
                        "Iphone 15",
                        25000000,
                        "Apple Phone",
                        "Apple"));

        products.put(2L,
                new Product(
                        2L,
                        "Galaxy S24",
                        22000000,
                        "Samsung Phone",
                        "Samsung"));

        products.put(3L,
                new Product(
                        3L,
                        "Xiaomi 14",
                        15000000,
                        "Xiaomi Phone",
                        "Xiaomi"));
    }

    @Override
    public Iterable<Product> findAll() {
        return products.values();
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(Long id) {
        products.remove(id);
    }
}