package org.skypro.skyshop.product;

public abstract class Product
{
    private String name;

    public Product(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    abstract public int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString()
    {
        return name;
    }
}
