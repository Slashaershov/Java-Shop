package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class ProductBasket
{
    private LinkedList<Product> products = new LinkedList<>();

    public void add(Product newProduct)
    {
        if (newProduct == null)
        {
            throw new IllegalArgumentException("new product is null");
        }
        products.add(newProduct);
    }

    public int getPrice()
    {
        int res = 0;
        for (Product x : products)
        {
            res += x.getPrice();
        }
        return res;
    }

    public List<Product> remove(String name)
    {
        Iterator<Product> iterator = products.iterator();
        List<Product> res = new LinkedList<>();
        while (iterator.hasNext())
        {
            Product product = iterator.next();
            if (product.getName().equals(name))
            {
                iterator.remove();
                res.add(product);
            }
        }
        return res;
    }


    public void print()
    {
        int sum = 0;
        int specialProductCount = 0;
        for (Product x : products)
        {
            System.out.println(x);
            sum += x.getPrice();
            if (x.isSpecial())
            {
                specialProductCount++;
            }
        }
        if (sum == 0)
        {
            System.out.println("в корзине пусто");
        }
        else
        {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialProductCount);
        }
    }

    public boolean checkProduct(String name)
    {
        for (Product x : products)
        {
            if (x.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        products.clear();
    }
}
