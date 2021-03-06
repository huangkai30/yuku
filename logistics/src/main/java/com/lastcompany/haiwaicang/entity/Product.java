package com.lastcompany.haiwaicang.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity


@Table(name = "product",indexes = {@Index(name="id",columnList = "id",unique = true)})

public class Product implements Serializable {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @Column(name="sku", unique = true,length = 128)
    private String sku;
    @Column(name="name", columnDefinition="TEXT")
    private String name;

    @Column(name="brand", columnDefinition="TEXT")
    private String brand;


    @Column(name="inventory")
    private int inventory=0;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @Column(name="lastpersion")
    private String lastpersion;

    @Column(name="dateCreated")
    @CreatedDate
    private Date dateCreated;

    @Column(name="dateModified")
    @LastModifiedDate
    private Date dateModified;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLastpersion() {
        return lastpersion;
    }

    public void setLastpersion(String lastpersion) {
        this.lastpersion = lastpersion;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}