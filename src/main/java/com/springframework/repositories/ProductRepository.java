package com.springframework.repositories;

import com.springframework.services.ProductService;
import com.springframework.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    @Service
    class ProductServiceImpl implements ProductService {
        private ProductRepository productRepository;

        @Autowired
        public void setProductRepository(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public Iterable<Product> listAllProducts() {
            return productRepository.findAll();
        }

        @Override
        public Product getProductById(Integer id) {
            return productRepository.findById(id).orElse(null);
        }

        @Override
        public Product saveProduct(Product product) {
            return productRepository.save(product);
        }
    }
}
