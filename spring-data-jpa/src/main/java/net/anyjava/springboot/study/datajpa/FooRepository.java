package net.anyjava.springboot.study.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<FooDomain, Long> {
}
