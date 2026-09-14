-- ============================================================
-- Setup DB สำหรับ 2jsp.jsp  (Resume Database)
-- DBMS: MariaDB (เข้ากันได้กับ com.mysql.cj.jdbc.Driver / jdbc:mysql://)
-- อ้างอิงค่าจากโค้ด: database = test, user = root, password = 1234
-- ============================================================

CREATE DATABASE IF NOT EXISTS test
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE test;

DROP TABLE IF EXISTS Resume;

CREATE TABLE Resume (
  Id       INT AUTO_INCREMENT PRIMARY KEY,   -- JSP อ่านผ่าน getString() ได้ (JDBC แปลง int->string ให้)
  Name     VARCHAR(100) NOT NULL,
  Surname  VARCHAR(100) NOT NULL,
  Address  VARCHAR(255)
);

INSERT INTO Resume (Name, Surname, Address) VALUES
  ('Somchai', 'Jaidee',  '123 Sukhumvit Rd, Bangkok'),
  ('Suda',    'Rakdee',  '45 Nimman Rd, Chiang Mai'),
  ('John',    'Smith',   '9 Beach Rd, Phuket'),
  ('Malee',   'Suksai',  '78 Ratchada Rd, Bangkok'),
  ('David',   'Brown',   '12 Riverside, Nonthaburi');
