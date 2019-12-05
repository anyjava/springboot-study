package net.anyjava.springboot.study.datajpa.fetch;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "order_m")
@NamedEntityGraph(name = "orderDetail", attributeNodes = @NamedAttributeNode("detail"))
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private String shopNumber;

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_detail_id")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private OrderDetail detail;
}
