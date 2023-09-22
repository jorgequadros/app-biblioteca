select * from categorias;

alter table livros drop autor;

alter table livros add autor varchar(50);

select * from livros;

select * from categorias where descricao like 'r%';

select * from livros AS l, categorias AS c where c.id=l.id_categoria;