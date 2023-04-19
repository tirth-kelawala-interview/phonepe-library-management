package model;

public class InventorySearchFilter {

    private String catagory;
    private Integer price;

    public InventorySearchFilter(Builder builder) {
        this.catagory = builder.catagory;
        this.price = builder.price;
    }

    public static class Builder {
        private String catagory;
        private Integer price;

        public static Builder newInstance()
        {
            return new Builder();
        }

        public Builder() {}

        public Builder setCatagory(String catagory) {
            this.catagory = catagory;
            return this;
        }

        public Builder setPrice(Integer price) {
            this.price = price;
            return this;
        }

        public InventorySearchFilter build()
        {
            return new InventorySearchFilter(this);
        }

    }

    public String getCatagory() {
        return catagory;
    }

    public Integer getPrice() {
        return price;
    }
}
