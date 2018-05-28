package com.lastcompany.haiwaicang.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity


@Table(name = "handle_records",indexes = {@Index(name="id",columnList = "id",unique = true)})

public class HandleRecords implements Serializable {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="userId")// 操作人的id
    private int userId;

    @Column(name="userName")// 操作人名称
    private String userName;

    @Column(name="type")//操作类型，1表示进库，2表示出库，3表示修改商品信息,4表示修改会员信息,5修改用户密码
    private String type;


    @Column(name="description", columnDefinition="TEXT")//描述
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}