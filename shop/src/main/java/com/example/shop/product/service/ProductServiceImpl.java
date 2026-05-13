package com.example.shop.product.service;

import com.example.shop.product.entity.Product;
import com.example.shop.product.repository.ProductRepository;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Long createProduct(ProductCreateRequest request) {
        List<Product> existingProduct = productRepository.findByName(request.getName());
        if (!existingProduct.isEmpty()) {
            throw new RuntimeException("이미 존재하는 상품번호입니다; " + request.getName());
        }

        Product product = new Product(
                request.getName(),
                request.getPrice(),
                request.getStock(),
                request.getDescription()
        );

        productRepository.save(product);
        return product.getId();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        return product;
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        product.updateInfo(request.getPrice(), request.getStock(), request.getDescription());

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }
}
