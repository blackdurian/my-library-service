-- Inserting data into borrower table
INSERT INTO borrower(id, name, email) VALUES (UUID_TO_BIN(UUID()), 'John Doe', 'john.doe@example.com');
INSERT INTO borrower(id, name, email) VALUES (UUID_TO_BIN(UUID()), 'Jane Doe', 'jane.doe@example.com');
INSERT INTO borrower(id, name, email) VALUES (UUID_TO_BIN(UUID()), 'Alice Smith', 'alice.smith@example.com');
INSERT INTO borrower(id, name, email) VALUES (UUID_TO_BIN(UUID()), 'Bob Johnson', 'bob.johnson@example.com');


-- Inserting data into book table
INSERT INTO book(id, isbn, title, author) VALUES (UUID_TO_BIN(UUID()), '978-3-16-148410-0', 'Book One', 'Author One');
INSERT INTO book(id, isbn, title, author) VALUES (UUID_TO_BIN(UUID()), '978-3-16-148410-1', 'Book Two', 'Author Two');
INSERT INTO book(id, isbn, title, author) VALUES (UUID_TO_BIN(UUID()), '978-3-16-148410-2', 'Book Three', 'Author Three');
INSERT INTO book(id, isbn, title, author) VALUES (UUID_TO_BIN(UUID()), '978-3-16-148410-3', 'Book Four', 'Author Four');
