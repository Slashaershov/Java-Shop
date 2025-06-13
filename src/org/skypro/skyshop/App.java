package org.skypro.skyshop;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.skypro.skyshop.customExceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;

public class App {

  public static void main(String[] args) {
    //demonstrateEx2();
    //demonstrateEx3();
    demonstrateSearchService();
  }

  private static void demonstrateSearchService() {
    SearchEngine searchService = new SearchEngine();
    searchService.add(new DiscontedProduct("doordoordoordoor4", 100, 5));
    searchService.add(new DiscontedProduct("doordoordoordoordoor3", 12, 5));
    searchService.add(new DiscontedProduct("doordoordoordoordoor1", 12, 5));
    searchService.add(new DiscontedProduct("doordoordoordoordoor9", 12, 5));
    searchService.add(new SimpleProduct("doordoordoor3", 100));
    searchService.add(new SimpleProduct("2doordoor2", 100));
    System.out.println("SearchService demonstrate for 'door'");
    printSearch("door", searchService);
    System.out.println("SearchService demonstrate for 'clar'");
    printSearch("clar", searchService);
  }

  public static void demonstrateEx3() {
    SearchEngine searchService = new SearchEngine();
    searchService.add(new DiscontedProduct("doordoordoordoor4", 100, 5));
    searchService.add(new DiscontedProduct("doordoordoordoor3", 12, 5));
    searchService.add(new SimpleProduct("doordoordoor3", 100));
    searchService.add(new SimpleProduct("2doordoor2", 100));
    System.out.println("Ex3 demonstrate for 'door'");
    printSearch("door", searchService);
    System.out.println("Ex3 demonstrate for 'clar'");
    printSearch("clar", searchService);
  }

  private static void demonstrateEx2() {
    ProductBasket basket = new ProductBasket();
    basket.add(new DiscontedProduct("door1", 100, 5));
    basket.add(new SimpleProduct("door2", 210));
    basket.add(new SimpleProduct("door1", 373));
    System.out.println("base basket");
    basket.print();
    System.out.println("------------------------");

    System.out.println("Delete exist");
    List<Product> removedItems = basket.remove("door1");
    System.out.println(removedItems);
    basket.print();
    System.out.println("------------------------");

    System.out.println("Delete not exist");
    removedItems = basket.remove("cat");
    if (removedItems.isEmpty()) {
      System.out.println("Список пуст");
    }
    basket.print();
    System.out.println("------------------------");
  }

  private static void tryInitiateOptionsWithError() {
    try {
      SimpleProduct p1 = new SimpleProduct("door1", -100);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }

    try {
      DiscontedProduct p2 = new DiscontedProduct(null, 100, 5);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }

    try {
      SimpleProduct sp2 = new SimpleProduct("", 100);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }

    try {
      DiscontedProduct p2 = new DiscontedProduct("6", 1, -4);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }
  }

  private static void printSearch(String str, SearchEngine searchSevice) {
    try {
      Set<Searchable> searches = searchSevice.search(str);
      for (Searchable search : searches) {
        System.out.println(search.searchTerm());
      }
      System.out.println();
    } catch (BestResultNotFound e) {
      System.out.println("matches not founded");
    }
  }
}

