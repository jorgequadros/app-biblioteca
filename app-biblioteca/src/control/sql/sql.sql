select * from categorias;

alter table livros drop dtAquisicao;

alter table livros add dtAquisicao date;

select * from livros;