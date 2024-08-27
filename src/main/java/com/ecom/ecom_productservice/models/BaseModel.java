package com.ecom.ecom_productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass //No table for this Parent Class - its child classes will have its attribute uuid
//@Entity
@Getter
@Setter
public class BaseModel {
    @Id //for PK
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @GeneratedValue(generator = "uuidgenerator")
//    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
//    private UUID uuid;

}

//GenerationType.AUTO -  persistence provider automatically selects an appropriate generation strategy
//GenerationType.IDENTITY - This strategy uses the database's auto-increment functionality to automatically generate unique identifier values. By default, the starting value for AUTO_INCREMENT is 1, and it increases by 1 for each new record
//GenerationType.SEQUENCE
//GenerationType.TABLE - persistence provider uses a separate database table to generate primary key values
