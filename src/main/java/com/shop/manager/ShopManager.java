package com.shop.manager;

import com.shop.model.Order;
import com.shop.model.Product;

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

  public void addProduct(Product product){
    if(products.length != ){

    }
  }


  public Product findProductById(String id){
    for (Product i : products){
      if(Objects.equals(id, i.getId())){
        return i;
      }
    }
    return null;
  }


}
