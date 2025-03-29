package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscontedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App
{
    public static void main(String[] args)
    {
        Product p1 = new SimpleProduct("door1", 100);
        Product p2 = new DiscontedProduct("door2", 200, 10);
        Product p3 = new DiscontedProduct("door3", 300, 10);
        Product p4 = new FixPriceProduct("door4");
        Product p5 = new FixPriceProduct("door5");
        Product p6 = new SimpleProduct("door6", 600);

        ProductBasket basket = new ProductBasket();

        basket.add(p1);
        basket.add(p2);
        basket.add(p3);
        basket.add(p4);
        System.out.println("basker 4 item check");
        basket.print();
        System.out.println("cost with 4 items: " + basket.getPrice());

        basket.add(p5);
        System.out.println("try add in full basket: ");
        basket.add(p6);

        System.out.println("find p3: " + basket.checkProduct(p3.getName()));
        System.out.println("find p6: " + basket.checkProduct(p6.getName()));

        basket.clear();

        System.out.println("basker empty check");
        basket.print();
        System.out.println("cost clean : " + basket.getPrice());

        basket.checkProduct(p3.getName());
    }
}
