package org.skypro.skyshop.services;

import java.util.LinkedList;
import java.util.List;
import org.skypro.skyshop.customExceptions.BestResultNotFound;

public class SearchEngine {

  private LinkedList<Searchable> allSearchableObjects;

  public SearchEngine() {
    allSearchableObjects = new LinkedList<>();
  }

  public void add(Searchable newItem) {
    allSearchableObjects.add(newItem);
  }

  public List<Searchable> search(String substr) throws BestResultNotFound {
    if (substr == null || substr.isBlank()) {
      throw new IllegalArgumentException("substr is empty");
    }
    int maxRepeatCount = 0;
    int currentRepeatCount = 0;
    LinkedList<Searchable> result = new LinkedList<>();
    for (Searchable searchable : allSearchableObjects) {
      currentRepeatCount = searchable.getSearchTerm(substr);
      if (currentRepeatCount > maxRepeatCount) {
        maxRepeatCount = currentRepeatCount;
        result.clear();
        result.add(searchable);
      } else if (currentRepeatCount == maxRepeatCount && currentRepeatCount != 0) {
        result.add(searchable);
      }
    }
    if (result.isEmpty()) {
      throw new BestResultNotFound(substr);
    }
    return result;
  }
}
