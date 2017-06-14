-- A partir do conhecimento de procedures/functions e packages obtidos (rapidamente) 
-- crie uma package que permita eliminar cidades duplicadas. Para essa tarefa respeite as seguintes regras: -> 
-- identifique as cidades duplicadas; -> identifique os clientes que estão relacionados com ela; -> 
-- altere no cliente (idcidade) para manter apenas a cidade duplicada de menor ID; -> 
-- certificando-se que não há mais clientes utilizando cidades duplicadas elimine-as.
-- Utilize uma codificação que possibilite o uso de teste unitário.

  
create or replace pck_cidades as

end pck_cidades

  create or replace package body pck_cidades as
    CREATE PROCEDURE atualizar_Cidades_Clientes is
    
    select Idcidade from cliente
    
    cursor cCidades_duplicadas is
      Select Nome,Uf, min(IdCidade) as id_cidade_atualizar
      From Cidade 
      group by Nome,uf
      having count(Nome)>1; 
    
    cursor cClientes (vNome_Cidade in VARCHAR2, vCidade_UF in VARCHAR2) is
      select cli.idcliente,
            cli.nome as nome_cliente,
            cid.nome as nome_cidade,
            cid.UF  as cidade_UF      
      from cliente cli
      inner join cidade cid on cid.IDCidade = cli.IDCidade
      where cid.Nome = vNome_Cidade
      and cid.Uf = vCidade_UF;    
    BEGIN
      
      FOR cidade IN cCidades_duplicadas LOOP
        FOR cliente in cClientes (cidade.Nome, cidade.UF) LOOP        
            update cliente
            set IdCidade = cidade.id_cidade_atualizar
            where IdCliente = cliente.IdCliente
        END LOOP;     
      END LOOP;
      
    END atualizar_Cidades_Clientes;

  end pck_Cidades;