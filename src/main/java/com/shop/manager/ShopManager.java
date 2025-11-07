package com.shop.manager;

import com.shop.model.Order;
import com.shop.model.Product;

import javax.swing.*;
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
            System.out.println((i + 1) + ". [" + p.getId() + "] " + p.getName() + " - " + p.getPrice() + "원 (재고: " + p.getStock() + "개)");
        }
    }


    public Order createOrder() {
        //    새 Order 객체 생성
        Order order = new Order();
        //    생성 메시지 출력
        System.out.println("Oreder 객체 생성");
        //    Order 반환
        return order;
    }

    public void addOrderItem(Order order, String productId, int quantity) {

        // findProductById()로 상품 찾기
        //        findProductById(productId);

        // 상품이 없으면 에러 메시지 출력 후 return
        if (findProductById(productId) == null) {
            System.out.println("상품이 없습니다");
            return;
        }
        // isAvailable()로 재고 확인
        findProductById(productId).isAvailable(quantity);

        // 재고 부족시 에러 메시지 출력 후 return
        if (!findProductById(productId).isAvailable(quantity)) {
            System.out.println("재고가 부족합니다");
            return;
        }
        // order.addItem() 호출
        order.addItem(productId, quantity);

        // 추가 완료 메시지 출력
        System.out.println("상품 추가 완료");
    }

    public void processOrder(Order order) {
        order.calculateTotal(this);
        System.out.println("==== 주문 내역 ====");
        System.out.println("주문 ID: " + order.getOrderId());
        System.out.println("------------------");
        String[] productIds = order.getProductIds();
        int[] quantities = order.getQuantities();

        for (int i = 0; i < order.getItemCount(); i++) {
            Product product = findProductById(productIds[i]);
            if (product != null) {
                int itemTotal = product.getPrice() * quantities[i];
                System.out.println((i + 1) + ". " + product.getName() + " - 수량: " + quantities[i] + "개" + " / 금액: " + itemTotal + "원");
                System.out.println(product.getStock());
                product.decreaseStock(quantities[i]);
                System.out.println(product.getStock());
            }
        }
        System.out.println("------------------");
        System.out.println("총 금액: " + order.getTotalAmount() + "원");
        System.out.println("==================");
        orders[orderCount++] = order;
        order.complete();
    }

    public Order findOrderById(String orderId) {
        // 반복문으로 orders 배열 순회
        for (int i = 0; i < orderCount; i++) {
            // orderId가 일치하면 반환
            // 못 찾으면 null 반환
            if (orderId.equals(orders[i].getOrderId())) {
                return orders[i];
            }
        }
        return null;
    }

    public void printAllOrders() {
        // 반복문으로 모든 주문 출력
        for (int i = 0; i < orderCount; i++) {
            Order order = orders[i];
            System.out.println((i+1) + ". [" + order.getOrderId() + "] " + order.getTotalAmount() + "원 (" + order.getStatus() + ")");
        }
        // 형식: "번호. [주문ID] 총금액원 (상태)"
        // 예시: System.out.println((i+1) + ". [" + order.getOrderId() + "] " + order.getTotalAmount() + "원 (" + order.getStatus() + ")");
    }



}
