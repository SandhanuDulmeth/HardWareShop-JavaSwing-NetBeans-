/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwareshop.controller;

import hardwareshop.DBConnection.DBConnection;
import hardwareshop.model.Customer;
import hardwareshop.model.Item;
import hardwareshop.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandhanu
 */
public class SalesManagementController {

    public static boolean addItem(Sales sales) {
        Integer itemID = getSales().getLast().getSalesID();
        System.out.println(itemID);
        if (itemID == null) {
            itemID = 1;
        } else {
            itemID++;
        }
        int i = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("Insert into sales Values(?,?,?,?,?,?)");
            stm.setInt(1, itemID);
            stm.setInt(2, sales.getItemID());
            stm.setInt(3, sales.getCustomerID());
            stm.setInt(4, sales.getQuantity());
            stm.setDouble(5, sales.getTotalPrice());
            stm.setObject(6, LocalDateTime.now());

            i = stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i > 0;
    }

    public static ArrayList<Sales> getSales() {

        ArrayList<Sales> SalesList = new ArrayList<>();
        try {

            // (Integer itemID, Integer customerID, Integer quantity, Double TotalPrice)
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM sales";
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) {
                SalesList.add(new Sales(
                        rst.getInt(1),
                        rst.getInt(2),
                        rst.getInt(3),
                        rst.getInt(4),
                        rst.getDouble(5),
                        rst.getString(6)
                ));

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SalesList;
    }

    public static ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> CustomerList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "Select * From customers";
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);

            while (rst.next()) {
                CustomerList.add(
                        new Customer(
                                rst.getInt(1),
                                rst.getString(2),
                                rst.getString(3)
                        ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return CustomerList;
    }

    public static ArrayList<Item> getAllItems() {
        ArrayList<Item> ItemsList2 = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "Select * From items";
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);

            while (rst.next()) {

                ItemsList2.add(new Item(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getInt(4),
                        rst.getDouble(5)
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemsList2;
    }
}
