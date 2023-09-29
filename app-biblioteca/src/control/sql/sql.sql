select * from categorias;

alter table livros drop autor;

alter table livros add autor varchar(50);

select * from livros;

select * from categorias where descricao like 'r%';

select * from livros AS l, categorias AS c where c.id=l.id_categoria;

create table usuario (
	id int auto_increment not null,
    nome varchar(50) not null,
    endereco varchar(50) not null,
    cidade varchar(50) not null,
    bairro varchar(50) not null,
    cep int not null,
    telefone int not null,
    email varchar(20) not null,
    primary key(ID) ,
    index(nome)
);

insert into from usuario 