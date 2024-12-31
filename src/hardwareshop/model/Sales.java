/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwareshop.model;

/**
 *
 * @author sandhanu
 */
public class Sales {
    private Integer salesID;
    private Integer itemID;
    private Integer customerID;
    private Integer quantity;
    private Double TotalPrice;
    private String Date;
 public Sales(Integer salesID,Integer itemID, Integer customerID, Integer quantity, Double TotalPrice,String Date) {
        this.salesID=salesID;
     this.itemID = itemID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.TotalPrice = TotalPrice;
        this.Date=Date;
    }
    public Sales(Integer itemID, Integer customerID, Integer quantity, Double TotalPrice) {
        this.itemID = itemID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.TotalPrice = TotalPrice;
    }

    public Sales() {
    }

    public Sales(Integer salesID, Integer itemID, Integer customerID, Integer quantity, Double TotalPrice) {
        this.salesID = salesID;
        this.itemID = itemID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.TotalPrice = TotalPrice;
    }

    /**
     * @return the salesID
     */
    public Integer getSalesID() {
        return salesID;
    }

    /**
     * @param salesID the salesID to set
     */
    public void setSalesID(Integer salesID) {
        this.salesID = salesID;
    }

    /**
     * @return the itemID
     */
    public Integer getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the customerID
     */
    public Integer getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the TotalPrice
     */
    public Double getTotalPrice() {
        return TotalPrice;
    }

    /**
     * @param TotalPrice the TotalPrice to set
     */
    public void setTotalPrice(Double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

   
    
}
