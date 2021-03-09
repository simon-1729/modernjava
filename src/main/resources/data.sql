DROP TABLE IF EXISTS apple;

CREATE TABLE apple (
  id INT AUTO_INCREMENT PRIMARY KEY,
  color VARCHAR(250) NOT NULL,
  weight FLOAT NOT NULL
);

INSERT INTO apple (color, weight) VALUES
  ('GREEN', 138.10),
  ('RED', 141.31),
  ('GREEN', 121.90),
  ('GREEN', 158.41),
  ('RED', 126.18),
  ('RED', 189.31);