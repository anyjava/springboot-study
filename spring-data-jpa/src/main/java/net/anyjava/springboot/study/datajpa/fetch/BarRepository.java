package net.anyjava.springboot.study.datajpa.fetch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<BarDomain, Long> {
}
