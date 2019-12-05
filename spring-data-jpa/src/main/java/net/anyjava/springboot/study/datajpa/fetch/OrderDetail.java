package net.anyjava.springboot.study.datajpa.fetch;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "detail", optional = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id")
    private Order order;
}
