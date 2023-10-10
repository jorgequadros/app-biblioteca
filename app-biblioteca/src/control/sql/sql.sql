create table categorias(
	id mediumint auto_increment not null,
    descricao varchar(50) not null,
    obs varchar(100) not null,
    primary key(id),
    index(descricao)
);

create table livros(
	id mediumint auto_increment not null,
    titulo varchar(50) not null,
    id_categoria mediumint not null,
    assunto varchar(200),
    dtAquisicao date,
    primary key(id),
    foreign key(id_categoria) references categorias(id),
    index(titulo)
);

create table usuarios (
	id mediumint auto_increment not null,
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

create table emprestimos(
	id int auto_increment not null,
    id_usuario mediumint not null,
    id_livro mediumint not null,
    dt_retirada date not null,
    dt_devolucao date not null,
    foreign key(id_usuario) references usuarios(id),
    foreign key(id_livro) references livros(id),
    primary key(id),
    index(dt_devolucao)
    );

select * from usuarios;
select * from categorias;
select * from livros;
select * from categorias where descricao like 'r%';
select * from livros AS l, categorias AS c where c.id=l.id_categoria;

alter table livros drop id_categoria;
alter table livros add id_categoria mediumint;

INSERT INTO usuario (nome,endereco,cidade,bairro,cep,telefone,email,user,perfil) VALUES("jorge quadros","rua quatro","canoas","olaria",92035014,"51998746321","jorge.quadros@gmail.com","jorge.quadros", "Administrador");
INSERT INTO usuarios (nome,endereco,cidade,bairro,cep,telefone,email,usuario,pws,perfil) VALUES("Miriam Quadros","Rua um","Canoas","Olaria",92035014,"51998746321","miriam.souza@gmail.com","miriam.souza","12345","Operador")
