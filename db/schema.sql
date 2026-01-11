-- ATLAS Club (Iteración 0) - Esquema mínimo
CREATE TABLE IF NOT EXISTS club_member (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  full_name VARCHAR(120) NOT NULL,
  email VARCHAR(160) NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS facility (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(120) NOT NULL,
  facility_type VARCHAR(60) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS booking (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  member_id BIGINT NOT NULL,
  facility_id BIGINT NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  status VARCHAR(30) NOT NULL DEFAULT 'CREATED',
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_booking_member FOREIGN KEY (member_id) REFERENCES club_member(id),
  CONSTRAINT fk_booking_facility FOREIGN KEY (facility_id) REFERENCES facility(id)
);

-- Índices básicos para búsquedas frecuentes
CREATE INDEX IF NOT EXISTS idx_booking_member ON booking(member_id);
CREATE INDEX IF NOT EXISTS idx_booking_facility ON booking(facility_id);
CREATE INDEX IF NOT EXISTS idx_booking_start ON booking(start_time);
