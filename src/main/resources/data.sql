INSERT INTO BOOKING (id, name, booking_type, status, category)
VALUES ('413e2297-b84b-42ef-97ed-16a8a9d1d671', 'Jesse Meier', 'DAY', 'APPROVED', '4be5f5bf-8eb5-44ea-8eb5-a5e807856d09'),
       ('b8160463-01a0-4c7a-bd46-5b3716dbe4c6', 'Gus Gusman','AFTERNOON', 'APPROVED', 'e1eec954-6ef4-4926-8183-7575af189f2a'),
       ('3c13c533-fbac-4881-b94d-f95cb2ef16c8', 'Jesse Meier','MORNING', 'APPROVED', '692fa28c-fafd-442b-8022-4ed792995053');

INSERT INTO MEMBER (id, username, email, firstname, lastname, password_hash, newsletter, is_admin)
VALUES ('9135f12e-1b66-4ee6-bbae-df37303cc154', 'admin', 'admin@admin.ch','admini', 'adminic', '$2a$10$aDD6I9Ej5.W8busvlsdPx.JvMWyJX8cOeOfVb.3q73KH2swww/N9C', true , true); -- Password: password1234