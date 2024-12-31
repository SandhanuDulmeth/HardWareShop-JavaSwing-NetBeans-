/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwareshop.controller;

import hardwareshop.DBConnection.DBConnection;
import hardwareshop.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandhanu
 */
public class CustomerManagementController {
    
      public static boolean removeCustomer(String customerID) {
        int executeUpdate = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement stm = connection.prepareStatement("DELETE FROM customers WHERE CustomerID=?");
            stm.setString(1, customerID);
            executeUpdate = stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return executeUpdate > 0;
        
    }
      public static boolean updateCustomer(Customer customer) {
        int executeUpdate = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE customers SET Name=?,ContactInfo=? WHERE CustomerID=? ");
            stm.setString(1, customer.getName());
            stm.setString(2, customer.getContactInfo());
             stm.setInt(3, customer.getCustomerID());
          
            executeUpdate = stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate > 0;
    }
      
    public static boolean addCustomer(Customer customer) {
      
        int i = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("Insert into customers Values(?,?,?)");
            //connection.createStatement()
            stm.setInt(1, customer.getCustomerID());
            stm.setString(2, customer.getName());
             stm.setString(3, customer.getContactInfo());
            
           
            i = stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i > 0;
    }
    
    
    
    
    
    
    
     public static Customer searchCustomer(int customerID) {
//          if(ItemCode)return null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
           
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM customers WHERE CustomerID=?");
            stm.setInt(1, customerID);
            ResultSet rst = stm.executeQuery();

            if (rst.next()) {
                return (new Customer(
                        rst.getInt(1),
                          rst.getString(2),
                         rst.getString(3)
                ));
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException e){
            System.out.println("not found");
        }
        return null;

    }
    
    
      public static ArrayList<Customer> getCustomer() {
           ArrayList<Customer> customerList = new ArrayList<>();
          try {
             
              
              
              Connection connection = DBConnection.getInstance().getConnection();
              String SQL = "SELECT * FROM customers";
              Statement stm = connection.createStatement();
              ResultSet rst = stm.executeQuery(SQL);
              while (rst.next()) {
                  customerList.add(new Customer(
                          rst.getInt(1),
                          rst.getString(2),
                         rst.getString(3)
                         
                  ));
                                
              }
              
             
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
          }
           return customerList;
    }
}
