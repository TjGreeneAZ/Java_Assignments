CREATE SCHEMA CIS263;

DROP TABLE product;

CREATE TABLE product (
   prodNumber VARCHAR(10) NOT NULL UNIQUE,
   prodName VARCHAR(40) NOT NULL,
   department VARCHAR(20) NOT NULL,
   price DECIMAL(7,2),
   quantity INT
);

INSERT INTO product (prodNumber, prodName, department, price, quantity)
VALUES 
   ('B005OCFHHK', 'Harry Potter: 8-Film Collection', 'Movies and TV', 39.99, 45),
   ('B07XJ8C8F5', 'Echo Dot Smart Speaker', 'Electronics', 29.99, 30),
   ('B08G3MN6KP', 'Super Mario 3D All Stars', 'Video Games', 49.94, 12),
   ('B07JCRY8WP', 'Minecraft', 'Video Games', 29.88, 10),
   ('B082JP6VP5', 'John Wick: Chapters 1-3', 'Movies and TV', 22.29, 18),
   ('B07FKR6KXF', 'Fire 7 Tablet', 'Electronics', 49.99, 15),
   ('B075XLWML4', 'Roku Streaming Stick', 'Electronics', 47.92, 5);