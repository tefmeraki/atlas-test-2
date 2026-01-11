-- ATLAS Club MVP - Seed data for demo
INSERT INTO facility (name, type) VALUES
('Pista 1', 'TENIS'),
('Pista 2', 'TENIS'),
('Sala Fitness', 'GYM');

INSERT INTO club_member (full_name, email, join_date) VALUES
('Ana Pérez', 'ana@example.com', '2025-10-01'),
('Luis García', 'luis@example.com', '2025-11-12');

-- Example booking (uses member_id=1, facility_id=1)
INSERT INTO booking (member_id, facility_id, booking_date, start_time, end_time) VALUES
(1, 1, '2026-01-15', '18:00:00', '19:00:00');
