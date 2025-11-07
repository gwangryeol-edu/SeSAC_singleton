package com.shop.model;

import com.shop.manager.ShopManager;
import com.shop.utils.IdGenerator;
import com.shop.model.Product;

public class Order {
  private String orderId;           // 주문 ID (자동 생성)
  private String[] productIds;      // 주문한 상품 ID 배열 (크기 10)
  private int[] quantities;         // 각 상품의 수량 배열 (크기 10)
  private int itemCount;            // 현재 담긴 상품 종류 수
  private int totalAmount;          // 총 금액
  private String status;            // 주문 상태: "결제대기", "결제완료", "취소"

  public Order() {
    this.orderId = IdGenerator.getInstance().generateOrderId();
    this.productIds = new String[10];
    this.quantities = new int[10];
    this.itemCount = 0;
    this.totalAmount = 0;
    this.status = "결제대기";
  }



  public void addItem(String productId, int quantity){
    if(itemCount < 10 && quantity >= 1){
      productIds[itemCount] = productId;
      quantities[itemCount] = quantity;
      this.itemCount += 1;
    }
  }


  public void calculateTotal(ShopManager manager){
    this.totalAmount = 0;

    for(int i = 0;  i < productIds.length ; i ++){
      String id = Integer.toString(i);
      Product product = manager.findProductById(id);
      totalAmount += product.getPrice() * quantities[i];
    }

  }



  public void complete(){
    status = "결제완료";
  }







  public String getOrderId() {
    return orderId;
  }

  public String[] getProductIds() {
    return productIds;
  }

  public int[] getQuantities() {
    return quantities;
  }

  public int getItemCount() {
    return itemCount;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public String getStatus() {
    return status;
  }
}
