------------------------- Exercicio 01 -------------------------
select IDProduto,Nome from Produto 
where IDProduto not in( 
  select pro.IDProduto from produto pro
  inner join pedidoItem pItem on pItem.IDProduto = pro.IDProduto
  inner join pedido ped on ped.IDPedido = pItem.IDPedido
  where ped.datapedido > sysdate - 120);
  
------------------------ Exercicio 02 ----------------------------