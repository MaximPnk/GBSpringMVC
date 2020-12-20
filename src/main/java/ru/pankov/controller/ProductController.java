package ru.pankov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pankov.entity.Product;
import ru.pankov.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String productList(Model model) {

        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);

        return "product_list";
    }

    @GetMapping("/form/{id}")
    public String productSaveForm(@PathVariable(value = "id") Long id, Model model) {

        Product product = new Product();

        if (id != 0) {
            product = productService.getProduct(id);
        }

        model.addAttribute("product", product);

        return "product_save_form";
    }

    @PostMapping("/save")
    public String productSave(@ModelAttribute("product") Product product) {

        productService.saveOrUpdate(product);

        return "redirect:/products/list";
    }
}
