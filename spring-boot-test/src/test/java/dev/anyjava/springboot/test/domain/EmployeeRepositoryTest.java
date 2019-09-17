package dev.anyjava.springboot.test.domain;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EmployeeRepositoryTest {

    private static final Long ANY_EMPLOYEE_ID = 1L;

    @Autowired
    private EmployeeRepository employeeRepository;

    @DatabaseSetup("/dbunit/employee.xml")
    @Test
    public void testFindById() {
        Employee employee = employeeRepository.findById(ANY_EMPLOYEE_ID).orElse(null);

        assertThat(employee).isNotNull();
    }
}