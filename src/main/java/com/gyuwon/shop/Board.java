package com.gyuwon.shop;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String title;
    public Date date;


}
