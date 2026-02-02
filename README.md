MediTrack — Система учёта приёмов врачей

Backend-система для медицинского учреждения на Java 17 + Spring Boot.

Технологии:
- Java 17
- Spring Boot, Spring Data JPA
- PostgreSQL
- REST API
- Тестирование: JUnit 5, Mockito, @DataJpaTest

 Возможности:
- Регистрация врачей и пациентов
- Создание приёмов
- Валидация входных данных
- Обработка ошибок (404, 400)
- Решение проблемы N+1 через @EntityGraph

Как запустить:
1. Запустите PostgreSQL через Docker:
   bash
   docker run --name meditrack-db -e POSTGRES_DB=meditrack -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5433:5432 -d postgres:15
