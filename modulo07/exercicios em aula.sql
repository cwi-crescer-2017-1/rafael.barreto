------------------------- Exercicio 01 -------------------------
CREATE VIEW vwProdutos_Sem_Compra as
select IDProduto,Nome from Produto 
where IDProduto not in( 
  select pro.IDProduto from produto pro
  inner join pedidoItem pItem on pItem.IDProduto = pro.IDProduto
  inner join pedido ped on ped.IDPedido = pItem.IDPedido
  where ped.datapedido > sysdate - 120); 

------------------------ Exercicio 02 ----------------------------

update produto
set Situacao = 'I'
where IdProduto IN (select IDProduto From VWPRODUTOS_SEM_COMPRA);


update produto
set Situacao = 'I'
where Exists (select IDProduto 
              From VWPRODUTOS_SEM_COMPRA vw
              where Produto.Idproduto = Vw.Idproduto); --> pode projetar mais de uma coluna e nao pode usar funcao de grupo.
              
------------------------ Exercicio 03 ----------------------------

select sum(item.Quantidade) qtde
from PedidoItem item
  inner join pedido ped on Ped.IDPedido = item.IDPedido
where item.IDProduto = :p_IDProduto
and ped.DataPedido >= trunc(sysdate, 'yyyy');










