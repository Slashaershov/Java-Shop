package org.skypro.skyshop.product;

public class Product
{
    private String name;
    private int cost;

    public Product(String name, int cost)
    {
        this.name = name;
        if (cost <= 0)
        {
            throw new IllegalArgumentException("cost <= 0");
        }
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }
}
