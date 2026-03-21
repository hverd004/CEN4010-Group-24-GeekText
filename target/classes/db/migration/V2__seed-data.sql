-- 1. Insert Publishers
INSERT INTO publisher (publisher_name) VALUES 
('Allen & Unwin'), ('Tor Books'), ('Orbit'), ('Del Rey'), ('Vintage');

-- 2. Insert Genres
INSERT INTO genre (genre_name) VALUES 
('Fantasy'), ('Science Fiction'), ('Mystery'), ('Classic'), ('Horror');

-- 3. Insert Authors
INSERT INTO author (first_name, last_name, biography, publisher_name) VALUES 
('J.R.R.', 'Tolkien', 'Father of modern high fantasy.', 'Allen & Unwin'),
('Brandon', 'Sanderson', 'Famous for the Cosmere universe.', 'Tor Books'),
('Andrzej', 'Sapkowski', 'Creator of The Witcher series.', 'Orbit'),
('Frank', 'Herbert', 'Best known for the Dune saga.', 'Del Rey');

-- 4. Insert Users (Feature 2 - Randomly Generated Usernames)
INSERT INTO user_profile (username, password, first_name, last_name, email, home_address) VALUES
('pixel_drifter99', 'p@ssw0rd1', 'Jordan', 'Smith', 'jsmith@example.com', '101 Maple St, Miami, FL'),
('cyber_knight_2026', 'cryptic77', 'Casey', 'Vance', 'cvance@example.com', '555 Tech Way, San Jose, CA'),
('book_worm_beta', 'readMore5', 'Morgan', 'Lee', 'mlee@example.com', '222 Library Ln, Austin, TX'),
('data_voyager', 'stats4life', 'Riley', 'Quinn', 'rquinn@example.com', '333 Logic Dr, Seattle, WA');

-- 5. Insert Credit Cards (Feature 2 - Standard Brands)
-- 'pixel_drifter99' has multiple cards for testing
INSERT INTO credit_card (username, card_brand, last4, exp_month, exp_year) VALUES
('pixel_drifter99', 'Visa', '4242', 12, 2028),
('pixel_drifter99', 'Mastercard', '5678', 05, 2030),
('cyber_knight_2026', 'American Express', '1001', 08, 2027),
('data_voyager', 'Discover', '9988', 11, 2029);

-- 6. Insert Books (Feature 1 & 4 - Including Lord of the Rings)
INSERT INTO book (isbn, title, description, price, year_published, copies_sold, avg_rating, author_id, publisher_name, genre_name) VALUES 
('978-001', 'The Fellowship of the Ring', 'The journey begins.', 25.00, 1954, 150000, 4.9, 1, 'Allen & Unwin', 'Fantasy'),
('978-002', 'The Two Towers', 'The battle for Middle-earth.', 25.00, 1954, 120000, 4.8, 1, 'Allen & Unwin', 'Fantasy'),
('978-003', 'The Return of the King', 'The epic conclusion.', 26.00, 1955, 140000, 4.9, 1, 'Allen & Unwin', 'Fantasy'),
('978-101', 'The Way of Kings', 'Epic fantasy beginning.', 24.99, 2010, 15000, 4.9, 2, 'Tor Books', 'Fantasy'),
('978-102', 'The Last Wish', 'Introducing Geralt of Rivia.', 14.50, 1993, 8000, 4.7, 3, 'Orbit', 'Fantasy'),
('978-103', 'Dune', 'Desert planet politics.', 19.99, 1965, 25000, 4.8, 4, 'Del Rey', 'Science Fiction'),
('978-106', 'Words of Radiance', 'Stormlight Archive Book 2.', 25.50, 2014, 12000, 4.9, 2, 'Tor Books', 'Fantasy'),
('978-110', 'The Final Empire', 'Mistborn series start.', 16.99, 2006, 9000, 4.7, 2, 'Tor Books', 'Fantasy');

-- 7. Insert Carts (Feature 3)
INSERT INTO cart (username) VALUES ('pixel_drifter99'), ('cyber_knight_2026'), ('book_worm_beta');

-- 8. Insert Cart Items (Feature 3 - Multiple items for 'pixel_drifter99')
INSERT INTO cart_item (cart_id, isbn, quantity) VALUES 
(1, '978-001', 1), -- Jordan has Fellowship of the Ring
(1, '978-103', 1), -- Jordan also has Dune
(2, '978-002', 1), -- Casey has The Two Towers
(3, '978-003', 1), -- Morgan has Return of the King
(3, '978-101', 1); -- Morgan also has Way of Kings