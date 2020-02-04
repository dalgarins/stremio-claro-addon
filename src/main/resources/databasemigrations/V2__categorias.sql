DROP TABLE IF EXISTS categorias;

CREATE TABLE categorias (
    filter_id VARCHAR(255)             PRIMARY KEY NOT NULL,
    from_ VARCHAR(255)                 NOT NULL,
    quantity VARCHAR(255)              NOT NULL,
    level_id VARCHAR(255)              NOT NULL,
    order_way VARCHAR(255)             NOT NULL,
    order_id VARCHAR(255)              NOT NULL,
    region VARCHAR(255)                NOT NULL
);