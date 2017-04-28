--exercicio 1

select *
into cidadeAux
from cidade ,


--exercicio 2
truncate table CidadeAux -- > limpa tabela	

insert into cidadeAux
select *
from cidade
where uf = 'RS'

-- insere dados na tabela auxiliar onde o campo uf tiver o valor RS

--exercicio 3

create table Produto(
	IDProduto int identity not null,	
	Nome varchar(15) not null,
	descricao varchar(40),
	dataCriacao varchar (10),
	localArmazenado varchar(20),
	Quantidade int,
	Preço float,
	constraint PK_IDProdutos primary key(IDProduto) 
)

--exercicio 4


insert into produto (nome)
values('produto1');

insert into produto (nome)
values('produto2');

select * from produto

