package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket
{
    private Product[] products = new Product[5];

    public void add(Product newProduct)
    {
        for (int i = 0; i < products.length; i++)
        {
            if (products[i] == null)
            {
                products[i] = newProduct;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getCost()
    {
        int res = 0;
        for (Product x : products)
        {
            if (x != null)
            {
                res += x.getCost();
            }
        }
        return res;
    }

    public void print()
    {
        int sum = 0;
        for (Product x : products)
        {
            if (x != null)
            {
                System.out.println(x.getName() + ": " + x.getCost());
                sum += x.getCost();
            }
        }
        if (sum == 0)
        {
            System.out.println("в корзине пусто");
        }
        else
        {
            System.out.println("Итого: " + sum);
        }
    }

    public boolean checkProduct(String name)
    {
        for (Product x : products)
        {
            if (x != null && x.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        Arrays.fill(products, null);
    }
}
