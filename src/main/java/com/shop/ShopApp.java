package com.shop;

import com.shop.manager.ShopManager;
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

//    >>> 시나리오 1: 초기 데이터 설정
//
//        [상품 등록] 노트북 - 1500000원
//        [상품 등록] 마우스 - 30000원
//        [상품 등록] Java책 - 35000원
//        [상품 등록] 키보드 - 80000원
        //2. 상품 조회

//    === 전체 상품 목록 ===
//        1. [P1] 노트북 - 1500000원 (재고: 5개)
//    2. [P2] 마우스 - 30000원 (재고: 20개)
//    3. [P3] Java책 - 35000원 (재고: 10개)
//    4. [P4] 키보드 - 80000원 (재고: 15개)
//
//    [검색: 전자기기]
//    1. 노트북 - 1500000원
//    2. 마우스 - 30000원
//    3. 키보드 - 80000원
        //3. 주문 생성 및 처리


//    >>> 시나리오 3: 주문 생성 및 처리
//
//    [주문 생성] O1
//
//        [주문 항목 추가] 노트북 x 1
//        [주문 항목 추가] 마우스 x 2
//        [주문 항목 추가] 키보드 x 1
//
//        === 주문 내역 ===
//        주문번호: O1
//        ----------------------------
//    노트북 x 1 = 1500000원
//    마우스 x 2 = 60000원
//    키보드 x 1 = 80000원
//        ----------------------------
//    총 금액: 1640000원
//
//        [결제 완료] O1
        //4. 전체 조회


//    >>> 시나리오 4: 전체 조회
//
//    === 전체 주문 ===
//    1. [O1] 1640000원 (결제완료)
//
//        === 재고 현황 ===
//        === 전체 상품 목록 ===
//    1. [P1] 노트북 - 1500000원 (재고: 4개)
//    2. [P2] 마우스 - 30000원 (재고: 18개)
//    3. [P3] Java책 - 35000원 (재고: 10개)
//    4. [P4] 키보드 - 80000원 (재고: 14개)
    }
}
