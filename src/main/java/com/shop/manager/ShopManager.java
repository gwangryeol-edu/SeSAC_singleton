package com.shop.manager;

import com.shop.model.Order;
import com.shop.model.Product;

import java.util.Arrays;
import java.util.Objects;

public class ShopManager {
    private Product[] products;  // 상품 배열 (크기 50)
    private int productCount;    // 현재 등록된 상품 수
    private Order[] orders;      // 주문 배열 (크기 50)
    private int orderCount;      // 현재 주문 수

    public ShopManager() {
        products = new Product[50];
        productCount = 0;
        orders = new Order[50];
        orderCount = 0;
    }

    public void addProduct(Product product) {
        if (products.length <= productCount) {
            throw new IllegalArgumentException("상품 배열이 가득 찼습니다.");
        }
        products[productCount++] = product;
    }


    public Product findProductById(String id) {
        for (Product i : products) {
            if (Objects.equals(id, i.getId())) {
                return i;
            }
        }
        return null;
    }

    public Product[] searchProductsByName(String keyword) {
        int count = 0;
        Product[] searchProduct = new Product[productCount];

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchProduct[count++] = product;
            }
        }
        return Arrays.copyOf(searchProduct, count);
    }

//    public Product[] searchProductsByCategory(String category) {
//        int count = 0;
//
//        Product[] searchProduct = new Product[productCount];
//        for (Product product : products) {
//            if (product.getCategory().toLowerCase().contains(category.toLowerCase())) {
//
//                searchProduct[count++] = product;
//            }
//        }
//        return searchProduct;
//    }
public Product[] searchProductsByCategory(String category) {
    int count = 0;
    Product[] searchProduct = new Product[productCount];

    for (int i = 0; i < productCount; i++) {  // ✅ productCount까지만 순회
        Product product = products[i];
        if (product.getCategory().toLowerCase().contains(category.toLowerCase())) {
            searchProduct[count++] = product;
        }
    }

    // ✅ 실제 검색된 개수만큼의 배열만 반환
    return Arrays.copyOf(searchProduct, count);
}
    public void printAllProducts() {
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            System.out.println((i+1) + ". [" + p.getId() + "] " + p.getName() + " - " + p.getPrice() + "원 (재고: " + p.getStock() + "개)");
        }
    }
}
