---------- LISTA 06 -----------------
--------- Exercicio 01 --------------

Select  SUBSTRING(nome, 1, CHARINDEX(' ', nome)) as cliente,
	    count(*) as reincidencia
from cliente
group by SUBSTRING(nome, 1, CHARINDEX(' ', nome))
order by reincidencia desc 
 

-- SUBSTRING (STRING, INICIO) ---> retorna apenas uma parte da string onde STRING e a palavra, INICIO e aonde comeca a string
-- CHARINDEX (expressionToFind , expressionToSearch , start_location) ---->   EXpression to find e o caractere que vai ser procurado, expression to search e a string aonde vai ser procurado este caractere, 



--------- Exercicio 02 --------------

select count (*) as 'total pedidos',
	   sum(valorPedido) as 'valor total do mes'		
from pedido
where datepart(month,dataPedido) = 4 and datepart(year,dataPedido) = 2017

--------- Exercicio 03 -------------- 


select * 
from (select top 1 cid.uf,
		count (*) as clientes
		from cliente cli
		inner join cidade cid on cid.IDCidade = cli.IDCidade
        group by cid.uf
		order by clientes
	  ) as menor

union

select * 
from (select top 1 cid.uf,
		count (*) as clientes
		from cliente cli
		inner join cidade cid on cid.IDCidade = cli.IDCidade
        group by cid.uf
		order by clientes desc
	  ) as maior

--------- Exercicio 04 -------------- 
insert into 


--------- Exercicio 05 --------------
select nome 
from produto pro
where not exists (select 1 from pedidoItem pItem where pItem.IDProduto = pro.IDproduto)

--------- Exercicio 06 --------------

select top 30 pro.nome,
	          sum(ped.valorPedido) as 'valor anual'	
from  produto pro
	inner join PedidoItem pITem on pItem.IDproduto = pro.IDproduto
	inner join pedido ped on ped.IDpedido = pItem.IdPedido
where datepart(year,ped.dataPedido) = 2016
group by(pro.nome)
order by 'valor anual' desc