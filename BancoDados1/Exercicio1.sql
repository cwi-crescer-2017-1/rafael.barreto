
--exercicio 1

select *
into cidadeAux
from cidade ,


--exercicio 2
truncate table CidadeAux -- > limpa tabela	

insert into cidadeAux (IDCidade,nome,uf) --> boa pratica colocar nome das colunas a serem copiadas
select (IDCidade,nome,uf)
from cidade
where uf = 'RS';

--> insere dados na tabela auxiliar onde o campo uf tiver o valor RS

--exercicio 3

create table Produto(
	IDProduto       int identity not null,	
	Nome            varchar(15) not null,
	descricao       varchar(40),
	dataCriacao     varchar (10),
	localArmazenado varchar(20),
	Quantidade      decimal(7,3), --> tem sete posicoes com 3 decimais ex: 9999.000
	Preço			decimal(9,2),
	 constraint PK_IDProdutos primary key(IDProduto) 
)

--exercicio 4


insert into produto (nome)
values('produto1');

insert into produto (nome)
values('produto2');

select localArmazenado as estoque  
from produto

select getdate(); --> puxa a data e hora atual do sistema(obs: data e hora do servidor )

select * from cidade
order by(nome);

/*  