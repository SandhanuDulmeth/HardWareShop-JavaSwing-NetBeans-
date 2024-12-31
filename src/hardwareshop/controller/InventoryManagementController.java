/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwareshop.controller;

import hardwareshop.DBConnection.DBConnection;
import hardwareshop.model.Item;
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
public class InventoryManagementController {
    
      public static boolean removeItem(String ItemCode) {
        int executeUpdate = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement stm = connection.prepareStatement("DELETE FROM items WHERE ItemID=?");
            stm.setString(1, ItemCode);
            executeUpdate = stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(InventoryManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return executeUpdate > 0;
        
    }
      public static boolean updateItem(Item item) {
        int executeUpdate = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE items SET Name=?,Description=?,Quantity=?,Price=? WHERE ItemID=? ");
            stm.setString(1, item.getName());
            stm.setString(2, item.getDescription());
            stm.setInt(3, item.getQuantity());
          stm.setDouble(4, item.getPrice());
            stm.setInt(5, item.getItemID());
            executeUpdate = stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(InventoryManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate > 0;
    }
      
    public static boolean addItem(Item item) {
      
        int i = 0;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("Insert into items Values(?,?,?,?,?)");
            //connection.createStatement()
            stm.setInt(1, item.getItemID());
            stm.setString(2, item.getName());
             stm.setString(3, item.getDescription());
              stm.setInt(4, item.getQuantity());
            stm.setDouble(5, item.getPrice());
           
            i = stm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InventoryManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i > 0;
    }
    
    
    
    
    
    
    
     public static Item searchItem(int ItemCode) {
//          if(ItemCode)return null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
           
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM items WHERE ItemID=?");
            stm.setInt(1, ItemCode);
            ResultSet rst = stm.executeQuery();

            if (rst.next()) {
                return (new Item(rst.getInt(1),
                          rst.getString(2),
                          rst.getString(3),
                          rst.getInt(4),
                          rst.getDouble(5) ));
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(InventoryManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException e){
            System.out.println("not found");
        }
        return null;

    }
    
    
      public static ArrayList<Item> getItems() {
           ArrayList<Item> itemList = new ArrayList<>();
          try {
             
              
              
              Connection connection = DBConnection.getInstance().getConnection();
              String SQL = "SELECT * FROM Items";
              Statement stm = connection.createStatement();
              ResultSet rst = stm.executeQuery(SQL);
              while (rst.next()) {
                  itemList.add(new Item(
                          rst.getInt(1),
                          rst.getString(2),
                          rst.getString(3),
                          rst.getInt(4),
                          rst.getDouble(5)  
                  ));
                                
              }
              
             
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(InventoryManagementController.class.getName()).log(Level.SEVERE, null, ex);
          }
           return itemList;
    }
}
