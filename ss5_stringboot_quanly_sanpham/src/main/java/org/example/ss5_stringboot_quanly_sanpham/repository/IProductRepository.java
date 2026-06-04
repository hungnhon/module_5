package org.example.ss5_stringboot_quanly_sanpham.repository;

import org.example.ss5_stringboot_quanly_sanpham.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository
        extends JpaRepository<Product,Integer> {
}