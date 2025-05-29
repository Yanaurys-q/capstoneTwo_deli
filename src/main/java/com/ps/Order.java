package com.ps;

import java.util.ArrayList;

public class Order
{
    private ArrayList<Product> products;

    public Order() { products = new ArrayList<>(); }
    public void addProduct(Product p) { products.add(0, p); }
    public ArrayList<Product> getProducts() { return products; }
    public double getTotal()
    {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }
    public String getOrderDetails()
    {
        StringBuilder sb = new StringBuilder();
        for (Product p : products)
        {
            sb.append(p.getDetails()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}

