package com.example.shoppingcart.dto;

import com.example.shoppingcart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productDtoIntegerMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productDtoIntegerMap) {
        this.productDtoIntegerMap = productDtoIntegerMap;
    }

    public Map<ProductDto, Integer> getProductDtoIntegerMap() {
        return productDtoIntegerMap;
    }

    public void setProductDtoIntegerMap(Map<ProductDto, Integer> productDtoIntegerMap) {
        this.productDtoIntegerMap = productDtoIntegerMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productDtoIntegerMap.containsKey(productDto)) {
            Integer currentValue = productDtoIntegerMap.get(productDto);
            productDtoIntegerMap.replace(productDto, currentValue + 1);// update
        } else {
            productDtoIntegerMap.put(productDto, 1); //add
        }
    }

    public void delete(ProductDto productDto) {
        productDtoIntegerMap.remove(productDto);
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
