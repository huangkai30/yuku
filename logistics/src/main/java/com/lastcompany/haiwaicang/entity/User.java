package com.lastcompany.haiwaicang.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity


@Table(name = "user",indexes = {@Index(name="id",columnList = "id",unique = true)})

public class User implements Serializable {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="user_name")
    private String userName;
    @Column(name="pass_word")
    private String passWord;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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