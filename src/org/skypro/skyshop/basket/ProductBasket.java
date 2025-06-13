package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import org.skypro.skyshop.product.Product;

import java.util.List;

public class ProductBasket {

  private Map<String, ArrayList<Product>> products = new LinkedHashMap<>();

  public void add(Product newProduct) {
    if (newProduct == null) {
      throw new IllegalArgumentException("new product is null");
    }
    String productName = newProduct.getName();
    List<Product> value = products.computeIfAbsent(productName, k -> new ArrayList<>());
    value.add(newProduct);
  }

  public int getPrice() {
    int res = 0;
    for (String key : products.keySet()) {
      for (Product x : products.get(key)) {
        res += x.getPrice();
      }
    }
    return res;
  }

  public List<Product> remove(String name) {
    List<Product> res = products.remove(name);
    if (res == null) {
      res = new ArrayList<Product>();
    }
    return res;
  }

  public void print() {
    int sum = 0;
    int specialProductCount = 0;
    for (String key : products.keySet()) {
      for (Product x : products.get(key)) {
        System.out.println(x);
        sum += x.getPrice();
        if (x.isSpecial()) {
          specialProductCount++;
        }
      }
    }
    if (sum == 0) {
      System.out.println("в корзине пусто");
    } else {
      System.out.println("Итого: " + sum);
      System.out.println("Специальных товаров: " + specialProductCount);
    }
  }

  public boolean checkProduct(String name) {
    return products.containsKey(name);
  }

  public void clear() {
    products.clear();
  }
}
