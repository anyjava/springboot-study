package net.anyjava.springboot.study.datajpa;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "foo")
@Audited
@Getter
@ToString
public class FooDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long cnt;
}
