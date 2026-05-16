package com.ecommerce.product_service.dataloader;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {

        Product product1 = Product.builder()
                .name("Product 1")
                .description("Description for Product 1")
                .price(new BigDecimal("19.99"))
                .build();

        productRepository.save(product1);

        System.out.println("Test data loaded: " + product1.getName());

    }
}
