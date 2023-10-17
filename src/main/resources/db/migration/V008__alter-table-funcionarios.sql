ALTER TABLE  funcionarios ADD COLUMN cargo_id int;
ALTER TABLE funcionarios ADD FOREIGN KEY (cargo_id) REFERENCES cargos(id);