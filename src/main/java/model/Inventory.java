package model;

import java.util.Objects;

public class Inventory {

    private String productId;
    private String catagory;
    private String subCatagory;
    private int price;
    private int size;

    public Inventory(String productId, String catagory, String subCatagory, int price, int size) {
        this.productId = productId;
        this.catagory = catagory;
        this.subCatagory = subCatagory;
        this.price = price;
        this.size = size;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getSubCatagory() {
        return subCatagory;
    }

    public void setSubCatagory(String subCatagory) {
        this.subCatagory = subCatagory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return price == inventory.price && size == inventory.size && productId.equals(inventory.productId) && Objects.equals(catagory, inventory.catagory) && Objects.equals(subCatagory, inventory.subCatagory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, catagory, subCatagory, price, size);
    }
}
