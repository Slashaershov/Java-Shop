package org.skypro.skyshop.product;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
