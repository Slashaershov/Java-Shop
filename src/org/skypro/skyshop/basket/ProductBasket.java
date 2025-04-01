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

    public int getPrice()
    {
        int res = 0;
        for (Product x : products)
        {
            if (x != null)
            {
                res += x.getPrice();
            }
        }
        return res;
    }

    public void print()
    {
        int sum = 0;
        int specialProductCount= 0;
        for (Product x : products)
        {
            if (x != null)
            {
                System.out.println(x);
                sum += x.getPrice();
                if (x.isSpecial()){
                    specialProductCount++;
                }
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
