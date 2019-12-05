package net.anyjava.springboot.study.datajpa.fetch;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Sql(statements = {"DELETE FROM order_m",
            "insert into order_m ( id, shop_number, order_date ) values ( 1, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 2, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 3, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 4, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 5, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 6, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 7, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 8, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 9, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 10, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 11, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 12, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 13, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 14, '1', now() )",
            "insert into order_m ( id, shop_number, order_date ) values ( 15, '1', now() )",
    })
    @DisplayName("Entity Graph 로 N+1 문제 해결")
    @Test
    public void findByShopNumbers() {
        assertThat(orderRepository.findByShopNumberIn(Lists.list("1"))).isNotNull();
    }

    @Sql(statements = {"DELETE FROM order_m", "insert into order_m ( id, shopNumber, order_date ) values ( 1, '1', now() )"})
    @Test
    public void findById() {
//        assertThat(orderRepository.findAll().size()).isEqualTo(1);

        assertThat(orderRepository.findById(1L)).isNotNull();
    }

    @Sql(statements = {
            "DELETE FROM order_m",
            "DELETE FROM order_detail",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 1, '1', now(), 1 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 2, '1', now(), 2 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 3, '1', now(), 3 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 4, '1', now(), 4 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 5, '1', now(), 5 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 6, '1', now(), 6 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 7, '1', now(), 7 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 8, '1', now(), 8 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 9, '1', now(), 9 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 10, '1', now(), 10 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 11, '1', now(), 11 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 12, '1', now(), 12 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 13, '1', now(), 13 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 14, '1', now(), 14 )",
            "insert into order_m ( id, shop_number, order_date, order_detail_id ) values ( 15, '1', now(), 15 )",
            "insert into order_detail ( id, name ) values (1, 'cuddy' )",
            "insert into order_detail ( id, name ) values (2, 'cuddy' )",
            "insert into order_detail ( id, name ) values (3, 'cuddy' )",
            "insert into order_detail ( id, name ) values (4, 'cuddy' )",
            "insert into order_detail ( id, name ) values (5, 'cuddy' )",
            "insert into order_detail ( id, name ) values (6, 'cuddy' )",
            "insert into order_detail ( id, name ) values (7, 'cuddy' )",
            "insert into order_detail ( id, name ) values (8, 'cuddy' )",
            "insert into order_detail ( id, name ) values (9, 'cuddy' )",
            "insert into order_detail ( id, name ) values (10, 'cuddy'  )",
            "insert into order_detail ( id, name ) values (11, 'cuddy'  )",
            "insert into order_detail ( id, name ) values (12, 'cuddy'  )",
            "insert into order_detail ( id, name ) values (13, 'cuddy'  )",
            "insert into order_detail ( id, name ) values (14, 'cuddy'  )",
            "insert into order_detail ( id, name ) values (15, 'cuddy'  )",
    })
    @DisplayName("EAGER 인데 N+1 문제가 발생")
    @Test
    public void findAllByShopNumbers() {
        List<Order> list = orderRepository.findAllByShopNumberIn(Lists.list("1"));
        assertThat(list).isNotNull();
        assertThat(list.get(0).getDetail()).isNotNull();
    }
}