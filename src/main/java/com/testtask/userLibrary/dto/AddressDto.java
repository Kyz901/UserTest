package com.testtask.userLibrary.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddressDto {
    private String postalCode;
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
}
