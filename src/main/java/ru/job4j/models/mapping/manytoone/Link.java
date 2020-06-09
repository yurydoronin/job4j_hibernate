package ru.job4j.models.mapping.manytoone;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
// ...

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "site_id", nullable = false, updatable = false)
    private Link link;

// ... getters and setters
}

