package org.skypro.skyshop.product;

import org.skypro.skyshop.services.Searchable;

public class Article implements Searchable
{
    private String name;
    private String text;

    public Article (String name, String text){
        this.name = name;
        this.text = text;
    }
    @Override
    public String toString()
    {
        return name + "/n" + text;
    }

    @Override
    public String searchTerm()
    {
        return name + ". " + text;
    }

    @Override
    public String getType()
    {
        return "ARTICLE";
    }
}
