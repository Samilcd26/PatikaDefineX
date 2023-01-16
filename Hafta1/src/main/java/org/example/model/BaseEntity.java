package org.example.model;

import java.util.List;

public class BaseEntity {
    public String type;
    public String name;
    public int rooms;
    public double area;
    public double price;

    BaseEntity(String type,String name,int rooms,double area,double price){
        this.type=type;
        this.name=name;
        this.rooms=rooms;
        this.area=area;
        this.price=price;
    }
}
