package ru.job4j.models.mapping.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;
    private String email;

    // ... getters and setters
}

