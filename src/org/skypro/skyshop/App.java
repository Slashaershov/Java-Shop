package org.skypro.skyshop;

import org.skypro.skyshop.customExceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;

public class App
{
    public static void main(String[] args)
    {
        SearchEngine searchSevice = new SearchEngine(10);
        tryInitiateOptionsWithError();
        demonstrateSearchPower(searchSevice);
    }

    private static void demonstrateSearchPower(SearchEngine searchSevice)
    {
        searchSevice.add(new DiscontedProduct("doordoordoordoor4", 100, 5));
        searchSevice.add(new SimpleProduct("doordoordoor3", 100));
        searchSevice.add(new SimpleProduct("2doordoor2", 100));
        printSearch("door", searchSevice);
        printSearch("clar", searchSevice);
    }

    private static void tryInitiateOptionsWithError()
    {
        try
        {
            SimpleProduct p1 = new SimpleProduct("door1", -100);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }

        try
        {
            DiscontedProduct p2 = new DiscontedProduct(null, 100, 5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }

        try
        {
            SimpleProduct sp2 = new SimpleProduct("", 100);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }

        try
        {
            DiscontedProduct p2 = new DiscontedProduct("6", 1, -4);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }
    }

    private static void printSearch(String str, SearchEngine searchSevice)
    {
        try
        {
            Searchable search = searchSevice.search(str);
            System.out.println(search.searchTerm());
            System.out.println();
        }
        catch (BestResultNotFound e)
        {
            System.out.println("matches not founded");
        }
    }
}

