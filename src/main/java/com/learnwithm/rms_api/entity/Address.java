package com.learnwithm.rms_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseNo;

    private String streetName;

    private String city;

    private Long postalCode;
}
