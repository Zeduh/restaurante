create table clientes (
    id int not null auto_increment primary key ,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    ativo boolean
);