package com.learnwithm.rms_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User {

    private  String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String mobile;

    private String email;

//    private Address address;
}
