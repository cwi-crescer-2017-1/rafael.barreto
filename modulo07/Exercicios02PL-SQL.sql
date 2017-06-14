--Atualmente a tabela de Cidade tem registros duplicados (nome e UF). Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
--Após isso liste todos os clientes que estão relacionados com estas cidades

DECLARE
Cursor c_duplicadas Is
  Select Nome,Uf, count(Nome) quantidade
  From Cidade 
  group by Nome,uf
  having count(Nome)>1;

Cursor Clientes(vNome_Cidade in VARCHAR2, vCidade_UF in VARCHAR2) is
  select cli.nome as Nome_Cliente, cid.nome as Nome_Cidade
  from cliente cli
  inner join cidade cid on cid.IDCidade = cli.IDCidade
  where cid.Nome = vNome_Cidade
  and cid.Uf = vCidade_UF;
 
 BEGIN 
  
  FOR cidade IN c_duplicadas LOOP 
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    DBMS_OUTPUT.PUT_LINE(CIDADE.NOME);
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    FOR cliente in Clientes(cidade.Nome, cidade.UF) LOOP        
        DBMS_OUTPUT.PUT_LINE(cliente.Nome_Cliente);        
    END LOOP;    
  END LOOP;  
END;

create index IX_Cidade_NomeUF on Cidade(Nome,UF);
create index IX_Cliente_Cidade on Cliente(IDCidade);

-------------------------- resposta exercicio 02 -------------------------------

CREATE OR REPLACE
PROCEDURE Atualiza_Valor_Pedido (pIDPedido IN INTEGER) AS
  vValorPedido  Pedido.ValorPedido%type;
BEGIN

   Select SUM(Quantidade * PrecoUnitario)
   into   vValorPedido
   From   PedidoItem
   Where  IDPedido = pIDPedido;
   
   Update Pedido
   Set    ValorPedido = vValorPedido
   Where  IDPedido    = pIDPedido;

END;