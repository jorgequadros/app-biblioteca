select * from categorias;
alter table livros drop autor;
alter table livros add autor varchar(50);
select * from livros;
select * from categorias where descricao like 'r%';
select * from livros AS l, categorias AS c where c.id=l.id_categoria;

create table usuarios (
	id int auto_increment not null,
    nome varchar(50) not null,
    endereco varchar(50) not null,
    cidade varchar(50) not null,
    bairro varchar(50) not null,
    cep int not null,
    telefone varchar(11) not null,
    email varchar(20) not null,
    user varchar(20),
    pws varchar(20),
    perfil varchar(20),
    primary key(ID) ,
    index(nome)
);

alter table usuarios add usuario varchar(20);
alter table usuario add pws varchar(10);
alter table usuario add perfil varchar(20);
alter table usuario add telefone smallint; 
select * from usuarios;
alter table usuario drop pws; 
alter table usuario drop telefone; 
alter table usuario add telefone bigint; 
alter table usuarios drop email; 
alter table usuarios add email varchar(100); 
drop table usuario;
INSERT INTO usuario (nome,endereco,cidade,bairro,cep,telefone,email,user,perfil) VALUES("jorge quadros","rua quatro","canoas","olaria",92035014,"51998746321","jorge.quadros@gmail.com","jorge.quadros", "Administrador");

INSERT INTO usuarios (nome,endereco,cidade,bairro,cep,telefone,email,usuario,pws,perfil) VALUES("Miriam Quadros","Rua um","Canoas","Olaria",92035014,"51998746321","miriam.souza@gmail.com","miriam.souza","12345","Operador")
