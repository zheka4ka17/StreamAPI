package com.company.product;

public class Product {
    private Long id;
    private String category;
    private String name;
    private Double price;



    public void setPrice(Double price) {
        this.price = price;
    }

    public Product(Long id, String category, String name, Double price) {

        this.id
                = id;
        this.category = category;

        this.name
                = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category+
                ", name=" + name +
                ", price=" + price+
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
