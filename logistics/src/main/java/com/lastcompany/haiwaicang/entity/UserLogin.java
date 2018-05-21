package com.lastcompany.haiwaicang.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity


@Table(name = "user_login",indexes = {@Index(name="id",columnList = "id",unique = true)})

public class UserLogin implements Serializable {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="userId")// 登陆人的id
    private int userId;

    @Column(name="userName")// 登陆人名称
    private int userName;

    @Column(name="type")//操作类型，用户登陆，2后台登陆
    private String type;


    @Column(name="description")//描述
    private String description;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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