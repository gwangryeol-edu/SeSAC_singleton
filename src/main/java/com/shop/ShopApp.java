package com.shop;

import com.shop.manager.ShopManager;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.utils.IdGenerator;

public class ShopApp {


    public static void main(String[] args) {
        // 4가지 시나리오 실행
        ShopManager shopManager = new ShopManager();
        //1. 초기 데이터 설정
        System.out.println(">>> 시나리오 1: 초기 데이터 설정\n");

        // 상품 3-4개 생성
        Product product1 = new Product("노트북", 1500000, 5, "전자기기");
        Product product2 = new Product("마우스", 30000, 20, "전자기기");
        Product product3 = new Product("Java책", 35000, 10, "도서");
        Product product4 = new Product("키보드", 80000, 15, "전자기기");

        // 매니저에 등록
        shopManager.addProduct(product1);
        shopManager.addProduct(product2);
        shopManager.addProduct(product3);
        shopManager.addProduct(product4);

        System.out.println(">>> 시나리오 2: 상품 조회\n");

        // 전체 상품 출력
        shopManager.printAllProducts();

        // 카테고리 검색
        System.out.println("\n[검색: 전자기기]");
        Product[] electronics = shopManager.searchProductsByCategory("전자기기");
        for (int i = 0; i < electronics.length; i++) {
            Product p = electronics[i];
            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice() + "원");
        }

        System.out.println(">>> 시나리오 3: 주문 생성 및 처리\n");

        // 빈 주문 생성
        Order order = shopManager.createOrder();

        // 상품 추가 (product1, product2, product4의 getId() 사용)
        shopManager.addOrderItem(order, product1.getId(), 1);
        shopManager.addOrderItem(order, product2.getId(), 2);
        shopManager.addOrderItem(order, product4.getId(), 1);

        shopManager.processOrder(order);

        System.out.println(">>> 시나리오 4: 전체 조회\n");

// 전체 주문 출력
        shopManager.printAllOrders();

// 재고 현황 확인
        System.out.println("\n=== 재고 현황 ===");
        shopManager.printAllProducts();
    }
}
