package org.skypro.skyshop.product;

import java.util.Objects;
import org.skypro.skyshop.services.Searchable;

import java.lang.String;

public abstract class Product implements Searchable {

  private String name;

  public Product(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("name is null or empty");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  abstract public int getPrice();

  public abstract boolean isSpecial();

  @Override
  public String toString() {
    return name;
  }

  @Override
  public String searchTerm() {
    return name;
  }

  @Override
  public String getType() {
    return "PRODUCT";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
