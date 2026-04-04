package com.example.shop.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //@Transactional
    public Long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findByProductNumber(request.getProductNumber());
        if (existingProduct != null) {
            throw new RuntimeException("이미 존재하는 상품번호입니다; " + request.getProductNumber());
        }

        Product product = new Product(
                request.getProductNumber(),
                request.getProductName(),
                request.getProductPrice(),
                request.getDescription()
        );

        productRepository.save(product);

        return product.getId();
    }

    // @Transactional(readOnly = true)
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }
    //@Transactional
    public void UpdateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        product.updateInfo(request.getProductName(), request.getProductPrice(), request.getDescription());
    }

    //@Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }
}

