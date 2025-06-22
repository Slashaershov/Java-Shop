package org.skypro.skyshop.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.skypro.skyshop.customExceptions.BestResultNotFound;

public class SearchEngine {

  private Set<Searchable> allSearchableObjects;

  public SearchEngine() {
    allSearchableObjects = new HashSet<>();
  }

  public void add(Searchable newItem) {
    allSearchableObjects.add(newItem);
  }

  public Set<Searchable> search(String substr) throws BestResultNotFound {
    if (substr == null || substr.isBlank()) {
      throw new IllegalArgumentException("substr is empty");
    }
    int maxRepeatCount = 0;
    int currentRepeatCount = 0;
    OptionalInt maxRepeatCountOptional = allSearchableObjects.stream()
        .mapToInt(x -> x.getSearchTerm(substr))
        .max();
    if (maxRepeatCountOptional.isEmpty()) {
      throw new BestResultNotFound(substr);
    }
    else {
      maxRepeatCount = maxRepeatCountOptional.getAsInt();
      return allSearchableObjects.stream()
          .filter(x -> x.getSearchTerm(substr) == maxRepeatCount)
          .collect(Collectors.toCollection(() -> new TreeSet<>(new FindComporator())));
    }
  }

  private class FindComporator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
      String name1 = o1.searchTerm();
      String name2 = o2.searchTerm();
      if (name1.length() != name2.length()) {
        return Integer.compare(name1.length(), name2.length());
      }
      return name1.compareToIgnoreCase(name2);
    }
  }
}
