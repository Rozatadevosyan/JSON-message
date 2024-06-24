package com.kafka.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "kafka")
public class User {
    @Id
    private Integer id;
    private String name;
    private String surname;
    private int year;
}
