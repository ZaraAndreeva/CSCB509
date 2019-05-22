/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "requests")
@Data
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "isDone")
    private Boolean isDone;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "fixDate")
    private Date fixDate;

    @ManyToOne
    @JoinColumn(name = "fixUser")
    private User fixUser;
}
