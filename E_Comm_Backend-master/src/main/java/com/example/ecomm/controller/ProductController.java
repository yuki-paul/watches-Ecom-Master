package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Product;
import com.example.ecomm.service.ProductService;

@RestController
//@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/GetAllProducts")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping("/Addproduct")
    public String add(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String delete(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product Deleted";
    }

    @GetMapping("/Get/{id}")
    public Product get(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("/AddToCart/{productid}/{cartid}")
    public ResponseEntity<?> addToCart(@PathVariable int productid, @PathVariable int cartid) {
        return ResponseEntity.ok(productService.addProductToCart(productid, cartid));
    }

    @DeleteMapping("/RemoveFromCart/{productid}/{cartid}")
    public ResponseEntity<?> removeFromCart(@PathVariable int productid, @PathVariable int cartid) {
        return ResponseEntity.ok(productService.removeProductFromCart(productid, cartid));
    }

}
