package dev.anyjava.springboot.test.domain;

import javax.persistence.*;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String role;

}
