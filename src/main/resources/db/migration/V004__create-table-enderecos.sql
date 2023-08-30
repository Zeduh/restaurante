create table enderecos (
    id int not null auto_increment primary key ,
    cep varchar(255),
    rua varchar(255),
    cliente_id int,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);