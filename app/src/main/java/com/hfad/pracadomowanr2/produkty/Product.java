package com.hfad.pracadomowanr2.produkty;

public class Product {

    private int id;
    private String name;
    private Double price;
    private Double quantity;
    private String unit;

    public Product(int id, String name, Double price, Double quantity, String unit){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Product(String name, Double price, Double quantity, String unit){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getQuantity(){
        return quantity;
    }

    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

//    public boolean getBought(){
//        return bought;
//    }
//
//    public void setBought(boolean bought){
//        this.bought = bought;
//    }
}
