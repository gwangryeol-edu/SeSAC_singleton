package com.shop;

import com.shop.utils.IdGenerator;

public class ShopApp {


  public static void main(String[] args) {
    IdGenerator idGenerator = IdGenerator.getInstance();
    String a = idGenerator.generateProductId();

    System.out.println(a);
  }
}
