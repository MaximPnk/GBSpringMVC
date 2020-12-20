package ru.pankov.service;

import ru.pankov.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(long id);

    void saveOrUpdate(Product product);
}
