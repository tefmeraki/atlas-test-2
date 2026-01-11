# ATLAS Club MVP (Fase 3 - cierre)

## Requisitos
- Java 17+
- Maven 3.9+
- MySQL 8+

## 1) Base de datos
1. Crea una BD: `atlas_club`
2. Ejecuta:
   - `db/schema.sql`
   - `db/seed.sql` (opcional, recomendado para demo)

## 2) Backend
1. Edita `application.properties` (usuario/clave/URL)
2. Arranca:
   - `mvn spring-boot:run`
3. Health:
   - `GET http://localhost:8080/api/health`

## 3) Frontend (demo)
1. En carpeta `frontend/`:
   - `python -m http.server 5173`
2. Abre:
   - `http://localhost:5173`

## Guion de demo (2-3 minutos)
1. Mostrar `/api/health` (backend OK)
2. En frontend:
   - listar instalaciones
   - listar socios
   - crear socio nuevo
   - crear reserva
   - listar reservas (ver la nueva)

## Notas
- CORS permitido solo para `http://localhost:5173` (modo demo)
- Alcance acotado: sin login, sin edición/cancelación, sin UI compleja
