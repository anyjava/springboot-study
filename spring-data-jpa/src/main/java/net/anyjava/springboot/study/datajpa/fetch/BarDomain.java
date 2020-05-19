package net.anyjava.springboot.study.datajpa.fetch;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "bar_domain")
@Entity
@NoArgsConstructor
public class BarDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public BarDomain(Long id, String name) {
//        this.id = id;
        this.name = name;
    }
}
