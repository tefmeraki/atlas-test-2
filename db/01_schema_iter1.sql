
-- Iteración 1: Tablas núcleo MVP (alineadas con Fase 2)
CREATE TABLE IF NOT EXISTS actividad (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(120) NOT NULL,
  plazas_totales INT NOT NULL,
  activa BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS socio (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(120) NOT NULL,
  email VARCHAR(160)
);

CREATE TABLE IF NOT EXISTS inscripcion (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  socio_id BIGINT NOT NULL,
  actividad_id BIGINT NOT NULL,
  estado VARCHAR(30) NOT NULL DEFAULT 'ACTIVA',
  CONSTRAINT fk_ins_socio FOREIGN KEY (socio_id) REFERENCES socio(id),
  CONSTRAINT fk_ins_actividad FOREIGN KEY (actividad_id) REFERENCES actividad(id)
);
