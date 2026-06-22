package org.example.shoppingcart.service;

import org.example.shoppingcart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);
}