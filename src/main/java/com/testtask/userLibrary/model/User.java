package com.testtask.userLibrary.model;

import com.testtask.userLibrary.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String lastName;

    private String email;

    private String phone;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private String login;
    @Column(name = "pass")
    private String password;
    @Column(name = "is_deleted")
    private boolean deleted;




}
