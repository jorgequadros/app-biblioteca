create table categorias(
	id int auto_increment not null,
    descricao varchar(50) not null,
    obs varchar(100) not null,
    primary key(id),
    index(descricao)
);

create table livros(
	id int auto_increment not null,
    titulo varchar(50) not null,
    id_categoria int not null,
    assunto varchar(200),
    dtAquisicao date,
    primary key(id),
    foreign key(id_categoria) references categorias(id),
    index(titulo)
);

create table usuarios (
	id int auto_increment not null,
    nome varchar(50) not null,
    endereco varchar(50) not null,
    cidade varchar(50) not null,
    bairro varchar(50) not null,
    cep int not null,
    telefone varchar(11) not null,
    email varchar(20) not null,
    usuario varchar(20),
    pws varchar(20),
    perfil varchar(20),
    primary key(ID) ,
    index(nome)
);

create table emprestimos(
	id int auto_increment not null,
    id_usuario int not null,
    id_livro int not null,
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

update livros set titulo='Treinameno Avan�ado em VBA', autor='Sandra teste01', id_categoria=1, assunto='Programa��o em excel e access
Conceitos b�sicos e uso do edito VBA.', dtAquisicao=2012-01-01  where id=1;

INSERT INTO livros (titulo,assunto,id_categoria,dtAquisicao) VALUES("Treinameno Avan�ado em VBA","Programa��o em excel e access
Conceitos b�sicos e uso do edito VBA.",1,2012-01-01);

INSERT INTO categorias (descricao,obs) VALUES("Informática","Livros relacionados a Informática");

INSERT INTO usuarios (nome,endereco,cidade,bairro,cep,telefone,email,usuario,pws,perfil) VALUES("Miriam Quadros","Rua um","Canoas","Olaria",92035014,"51998746321","miriam.souza@gmail.com","miriam.souza","12345","Operador")
