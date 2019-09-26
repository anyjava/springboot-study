package net.anyjava.springboot.study.datajpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FooRepositoryTest {

    @Autowired
    private  FooRepository fooRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {
        assertThat(fooRepository).isNotNull();
    }

    /**
     * Audit Table JPA Data Revision 조회용 테스트
     * @Rollback(false) 로 해서 몇번 데이터 넣은 후 조회해 보세요.
     */
    @Test
    @Transactional
    public void testEnvers() {
        // Auto increment 값 LONG 범위로 조정
        String sql = "ALTER TABLE revinfo AUTO_INCREMENT = " + Integer.MAX_VALUE;
        log.info("SQL = {}", sql);
//        jdbcTemplate.update(sql);

        em.flush();

        log.info(">>>> revisionNumber {}", fooRepository.findRevisions(7L).getLatestRevision().getRevisionNumber());
        log.info(">>>> Foo {}", fooRepository.findRevisions(1L).getContent().get(0));
    }
}

