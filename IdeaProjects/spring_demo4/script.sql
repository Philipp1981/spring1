CREATE SCHEMA hibernate2;

CREATE TABLE products_2(id serial, title varchar(255), price integer, PRIMARY KEY (id));

postgres=#  INSERT INTO products_2(id, title, price) VALUES(1, 'volvo', 50000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(2, 'mercedes', 55000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(3, 'BMW', 53000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(4, 'audi', 54000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(5, 'fiat', 65000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(6, 'ford', 35000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(7, 'kia', 45000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(8, 'huindai', 44000);
INSERT 0 1
postgres=# INSERT INTO products_2(id, title, price) VALUES(9, 'seat', 25000),
postgres-# (10, 'renault', 30000),
postgres-# (11, 'citroen', 33000),
postgres-# (12, 'skoda', 34000),
postgres-# (13, 'VW', 41000);
INSERT 0 5
postgres=# INSERT INTO products_2(id, title, price) VALUES(14, 'land rover', 85000),
postgres-# (15, 'bentley', 100000),
postgres-# (16, 'rolls-royce', 150000),
postgres-# (17, 'ferrari', 155000),
postgres-# (18, 'lamborgini', 160000),
postgres-# (19, 'alfa romeo', 43000),
postgres-# (20, 'mini', 46000);
INSERT 0 7
postgres=# SELECT * FROM products_2;