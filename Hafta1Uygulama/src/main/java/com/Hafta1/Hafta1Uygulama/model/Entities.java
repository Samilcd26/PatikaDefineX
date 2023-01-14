package com.Hafta1.Hafta1Uygulama.model;

import jakarta.persistence.*;



@Entity
@Table(name = "entities")
public class Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "area")
    private int area;

    @Column(name = "price")
    private int price;

    @Column(name = "rooms")
    private int rooms;

    public Entities() {

    }

    public Entities(long id,String type, int area, int price,int rooms) {
        this.id = id;
        this.type = type;
        this.area = area;
        this.price = price;
        this.rooms=rooms;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }



}
