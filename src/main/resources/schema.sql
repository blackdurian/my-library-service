--CREATE TABLE IF NOT EXISTS persons(
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) DEFAULT NULL,
--    PRIMARY KEY (`id`)
--)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS borrower(
    `id` binary(16) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS book(
    `id` binary(16) NOT NULL,
    `isbn` varchar(255) DEFAULT NULL,
    `title` varchar(255) DEFAULT NULL,
    `author` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS record(
    `id` binary(16) NOT NULL,
    `borrower_id` binary(16) DEFAULT NULL,
    `book_id` binary(16) DEFAULT NULL,
    `status` int DEFAULT NULL,
    `borrow_time` timestamp NULL DEFAULT NULL,
    `return_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
