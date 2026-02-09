
-- Feature 2: Profile Management
CREATE TABLE user_profile (
    username TEXT PRIMARY KEY,  -- Username is a primary key because Features 2 and 3 use it.
    password TEXT NOT NULL,
    first_name TEXT,            -- Name is split between first and last to follow 1NF.
    last_name TEXT,
    email TEXT,
    home_address TEXT
);

-- Feature 2: Credit Cards
-- This is a one-to-many relationship. One user can have many credit cards.
-- To avoid duplicating the user data this is separated out. This follows 2NF/3NF.
CREATE TABLE credit_card (
    card_id SERIAL PRIMARY KEY,
    username TEXT REFERENCES user_profile(username),
    card_brand TEXT,
    last4 TEXT,
    exp_month INTEGER,
    exp_year INTEGER
);

-- Feature 1 & 4: Publishers
CREATE TABLE publisher (
    publisher_name TEXT PRIMARY KEY
);

-- Feature 1: Genre
CREATE TABLE genre (
    genre_name TEXT PRIMARY KEY
);

-- Feature 4: Authors
-- This is separated to avoid re-typing the author's biography every time they write a book. Avoid duplication.
CREATE TABLE author (
    author_id SERIAL PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    biography TEXT,
    publisher_name TEXT REFERENCES publisher(publisher_name)
);

-- Features 1 and 4: Book
-- This links together the Publisher, Genre, and Author table using ids/names as foreign keys.
CREATE TABLE book (
    isbn TEXT PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    price NUMERIC(10,2),
    year_published INTEGER,
    copies_sold INTEGER DEFAULT 0,
    avg_rating NUMERIC(3,2) DEFAULT 0.0,
    author_id INTEGER REFERENCES author(author_id),
    publisher_name TEXT REFERENCES publisher(publisher_name),
    genre_name TEXT REFERENCES genre(genre_name)
);

-- Feature 3: Shopping Cart
-- This table is so each user gets only 1 active shopping cart.
CREATE TABLE cart (
    cart_id SERIAL PRIMARY KEY,
    username TEXT REFERENCES user_profile(username)
);

-- Feature 3: Items in Cart
-- This table lets a single cart hold many different books. This follows 1NF.
CREATE TABLE cart_item (
    cart_item_id SERIAL PRIMARY KEY,
    cart_id INTEGER REFERENCES cart(cart_id),
    isbn TEXT REFERENCES book(isbn),
    quantity INTEGER DEFAULT 1
);