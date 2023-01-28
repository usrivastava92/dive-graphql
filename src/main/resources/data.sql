INSERT INTO author (author_id, first_name, last_name) VALUES (1, 'John', 'Smith');
INSERT INTO author (author_id, first_name, last_name) VALUES (2, 'Jane', 'Doe');
INSERT INTO author (author_id, first_name, last_name) VALUES (3, 'Bob', 'Johnson');

INSERT INTO publishers (publisher_id, name) VALUES (1, 'Publisher A');
INSERT INTO publishers (publisher_id, name) VALUES (2, 'Publisher B');
INSERT INTO publishers (publisher_id, name) VALUES (3, 'Publisher C');

INSERT INTO genres (genre_id, name) VALUES (1, 'Fiction');
INSERT INTO genres (genre_id, name) VALUES (2, 'Non-Fiction');
INSERT INTO genres (genre_id, name) VALUES (3, 'Mystery');

INSERT INTO book (isbn, title, author_id, publisher_id, genre_id) VALUES ('123-456-789', 'Book 1', 1, 1, 1);
INSERT INTO book (isbn, title, author_id, publisher_id, genre_id) VALUES ('987-654-321', 'Book 2', 2, 2, 2);
INSERT INTO book (isbn, title, author_id, publisher_id, genre_id) VALUES ('246-135-792', 'Book 3', 3, 3, 3);
