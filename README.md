# Spring Boot 학습을 위한 project 입니다.

## Spring Async reactive

TBD

## spring-cloud

TBD


## Spring Data JPA

* quick start

* 로컬 개발환경 구축

  * MySQL 을 Docker 로 뛰우고 구동해 주세요.
```docker
docker run --name mysql57 \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_ROOT_HOST='%' \
    --restart=unless-stopped \
    -d \
    mysql/mysql-server:5.7 \
    --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```