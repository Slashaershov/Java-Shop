package org.skypro.skyshop.product;

public class FixPriceProduct extends Product
{
    private final int FIX_PRICE = 20;

    public FixPriceProduct(String name)
    {
        super(name);
    }

    @Override
    public int getPrice()
    {
        return FIX_PRICE;
    }

    @Override
    public String toString()
    {
        return getName() + ": " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}
