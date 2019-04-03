package de.leittersdorf.graphqlexample.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Repo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String url;
}
