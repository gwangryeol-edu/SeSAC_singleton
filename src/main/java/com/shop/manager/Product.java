package com.shop.manager;

import com.shop.utils.IdGenerator;

public class Product {
  private String id;        // 상품 ID (자동 생성)
  private String name;      // 상품명
  private int price;        // 가격
  private int stock;        // 재고
  private String category;  // 카테고리


  //  수량이 0보다 큰지 확인
  //  재고가 충분한지 확인 (stock < quantity면 예외 발생)
  //stock -= quantity
  public void decreaseStock(int quantity){
    if (stock > 0){
      if(stock < quantity) throw new IllegalArgumentException("재고가 부족합니다.");
    }
    stock -= quantity;
  }

  //  수량이 0보다 큰지 확인
  //  stock += quantity
  public void increaseStock(int quantity){
    if (stock > 0){
      stock += quantity;
    }

  }

  //return stock >= quantity
  public boolean isAvailable(int quantity){
    return stock >= quantity;
  }















  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name == null || name.isEmpty()){
      throw new IllegalArgumentException("상품명은 필수입니다.");
    }
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    if(price < 0){
      throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
    }
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    if(stock < 0){
      throw new IllegalArgumentException("재고는 0 이상이어야 합니다.");
    }
    this.stock = stock;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    if(category == null || category.isEmpty()){
      throw new IllegalArgumentException("카테고리 입력 필수");
    }
    this.category = category;
  }

  public Product(String name, int price, int stock, String category) {
    this.id = IdGenerator.getInstance().generateProductId();
    setName(name);     // setter를 통한 유효성 검증
    setPrice(price);
    setStock(stock);
    setCategory(category);
  }


}

