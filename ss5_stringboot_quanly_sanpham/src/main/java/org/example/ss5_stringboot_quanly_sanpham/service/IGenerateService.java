package org.example.ss5_stringboot_quanly_sanpham.service;

import java.util.List;

public interface IGenerateService<T> {

    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void delete(Integer id);
}