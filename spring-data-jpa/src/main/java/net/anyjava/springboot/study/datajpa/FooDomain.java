package net.anyjava.springboot.study.datajpa;

import javax.persistence.*;

@Entity
@Table(name = "foo")
public class FooDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long cnt;
}
