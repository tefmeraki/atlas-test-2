-- ATLAS Club MVP - Schema (MySQL)
CREATE TABLE IF NOT EXISTS club_member (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(120) NOT NULL,
  email VARCHAR(120) NOT NULL UNIQUE,
  join_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS facility (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(120) NOT NULL,
  type VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS booking (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  member_id BIGINT NOT NULL,
  facility_id BIGINT NOT NULL,
  booking_date DATE NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  CONSTRAINT fk_booking_member FOREIGN KEY (member_id) REFERENCES club_member(id),
  CONSTRAINT fk_booking_facility FOREIGN KEY (facility_id) REFERENCES facility(id)
);
