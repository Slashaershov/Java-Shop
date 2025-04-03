package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;

public class App
{
    public static void main(String[] args)
    {
        SearchEngine searchSevice = new SearchEngine(10);
        searchSevice.add(new SimpleProduct("door1", 100));
        searchSevice.add(new DiscontedProduct("door2", 200, 10));
        searchSevice.add(new DiscontedProduct("door3", 300, 10));
        searchSevice.add(new FixPriceProduct("door4"));
        searchSevice.add(new FixPriceProduct("door5"));
        searchSevice.add(new FixPriceProduct("door21"));
        searchSevice.add(new FixPriceProduct("door7"));
        searchSevice.add(new Article("doorArticle", "door21 description"));

        printSearch("door", searchSevice);
        printSearch("oor2", searchSevice);
    }

    private static void printSearch(String str, SearchEngine searchSevice)
    {
        Searchable[] searches = searchSevice.search(str);
        for (Searchable x : searches)
        {
            if (x != null)
            {
                System.out.println(x.searchTerm());
            }
        }
        System.out.println();
    }
}
