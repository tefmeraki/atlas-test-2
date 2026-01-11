# Demo rápida (2-3 minutos)

1) Backend vivo
- GET http://localhost:8080/api/health

2) Frontend
- Abrir http://localhost:5173

3) Mostrar datos existentes
- Cargar instalaciones
- Cargar socios
- Cargar reservas

4) Crear un socio (form)
- Comprobar que aparece en listado

5) Crear una reserva
- Usar memberId del socio creado
- Usar facilityId de una instalación
- Ver que aparece en listado de reservas

## Fallos típicos y solución
- CORS: revisa WebConfig en backend (origin localhost:5173)
- BD vacía: ejecuta db/seed.sql
- Puerto ocupado: cambiar 5173 o 8080
