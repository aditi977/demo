package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private String email;
    private Integer numOrders;

    public Customer(){

    }

    public Customer(String name, Integer age, String email, Integer numOrders){
        this.name = name;
        this.age = age;
        this.email = email;
        this.numOrders = numOrders;
    }


}
