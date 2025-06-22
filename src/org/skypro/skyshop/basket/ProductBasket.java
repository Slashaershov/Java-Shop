package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
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
    return products.values().stream()
        .flatMap(List::stream)
        .mapToInt(Product::getPrice)
        .sum();
  }

  public List<Product> remove(String name) {
    List<Product> res = products.remove(name);
    if (res == null) {
      res = new ArrayList<Product>();
    }
    return res;
  }

  public void print() {
    List<Product> allProducts = products.values().stream()
        .flatMap(List::stream)
        .toList();
    allProducts.forEach(System.out::println);
    int sum = allProducts.stream()
        .mapToInt(Product::getPrice)
        .sum();
    if (sum == 0) {
      System.out.println("в корзине пусто");
    } else {
      System.out.println("Итого: " + sum);
      System.out.println("Специальных товаров: " + getSpecialCount(allProducts));
    }
  }

  private int getSpecialCount(List<Product> allProducts){
    return (int) allProducts.stream()
        .filter(Product::isSpecial)
        .count();
  }

  public boolean checkProduct(String name) {
    return products.containsKey(name);
  }

  public void clear() {
    products.clear();
  }
}
