package com.example.shop.product.dto;


import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class ProductUpdateRequest {

    @Min(value = 0, message = "가격은 0원 이상이어야 합니다.")
    private int price;

    @Min(value = 0, message = "재고는 0개 이상이어야 합니다.")
    private int stock;

    private String description;

    public ProductUpdateRequest(int price, int stock, String description) {
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
}
