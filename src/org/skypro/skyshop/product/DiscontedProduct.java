package org.skypro.skyshop.product;

public class DiscontedProduct extends Product
{
    private int basePrice;
    private int discount;

    public DiscontedProduct(String name, int price, int discount)
    {
        super(name);
        if (price <= 0)
        {
            throw new IllegalArgumentException("cost <= 0");
        }
        this.basePrice = price;
        this.discount = discount;
    }

    @Override
    public int getPrice()
    {
        return basePrice - basePrice * discount / 100;
    }

    @Override
    public String toString()
    {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}
