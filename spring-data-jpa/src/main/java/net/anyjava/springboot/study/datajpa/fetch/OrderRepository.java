package net.anyjava.springboot.study.datajpa.fetch;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    List<Order> findAllByShopNumberIn(Collection<String> shopNumbers);

    @EntityGraph(value = "orderDetail", type = EntityGraph.EntityGraphType.LOAD)
    List<Order> findByShopNumberIn(Collection<String> shopNumbers);
}
