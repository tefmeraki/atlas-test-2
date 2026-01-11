# ATLAS Club (Iteración 0) — Bootstrap

## Objetivo de esta iteración
- Arrancar un proyecto Spring Boot mínimo.
- Tener un endpoint de salud: `GET /api/health`
- Conectar con MySQL y validar el esquema (sin autogenerar tablas).
- Dejar preparada una estructura por capas (controller/service/repository/model).

## Cómo ejecutar (orientativo)
1) Crear BD `atlas_club` en MySQL.
2) Ejecutar `db/schema.sql` y opcionalmente `db/seed.sql`.
3) Ajustar credenciales en `backend/src/main/resources/application.properties`.
4) Ejecutar la app (desde IntelliJ o `mvn spring-boot:run`).
5) Probar:
   - `GET http://localhost:8080/api/health`
   - `GET http://localhost:8080/api/db/ping`

## NOTA ATLAS
En Fase 3 NO incluimos:
- login/roles
- frontend real
- docker
- microservicios
- pagos/integraciones externas
