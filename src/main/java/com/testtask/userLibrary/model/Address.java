package com.testtask.userLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "postalcode")
    private String postalCode;
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
}
