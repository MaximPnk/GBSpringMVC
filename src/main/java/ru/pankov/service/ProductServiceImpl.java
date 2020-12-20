package ru.pankov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pankov.dao.ProductDAO;
import ru.pankov.entity.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(productDAO.findAll());
    }

    @Override
    public Product getProduct(long id) {
        return productDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no product with id " + id));
    }

    @Override
    public void saveOrUpdate(Product product) {
        productDAO.saveOrUpdate(product);
    }
}
