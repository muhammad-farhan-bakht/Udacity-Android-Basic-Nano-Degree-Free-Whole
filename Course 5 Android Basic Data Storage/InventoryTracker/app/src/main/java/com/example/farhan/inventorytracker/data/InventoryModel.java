package com.example.farhan.inventorytracker.data;

public class InventoryModel {

    private final String productName;
    private final String productPrice;
    private final int productQuantity;
    private final String supplierName;
    private final String supplierPhone;
    private final String supplierEmail;
    private final String image;

    public InventoryModel(String productName, int productQuantity, String productPrice, String supplierName, String supplierPhone, String supplierEmail, String image) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "InventoryModel{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productQuantity=" + productQuantity +
                ", supplierName='" + supplierName + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
