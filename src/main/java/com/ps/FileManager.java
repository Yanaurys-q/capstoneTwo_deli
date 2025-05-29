package com.ps;

import java.io.IOException;
import java.io.PrintWriter;

public class FileManager
{
    public void saveOrder(Order order, String filename, String customerName)
    {
        try (PrintWriter out = new PrintWriter(filename))
        {
            out.println("Customer: " + customerName);
            out.println(order.getOrderDetails());
            System.out.println("Order saved as " + filename);
        }
        catch (IOException e)
        {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }
}
