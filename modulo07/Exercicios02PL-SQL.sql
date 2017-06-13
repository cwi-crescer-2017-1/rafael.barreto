--Atualmente a tabela de Cidade tem registros duplicados (nome e UF). Fa�a um c�digo (PL/SQL) que liste quais s�o as cidades duplicadas. 
--Ap�s isso liste todos os clientes que est�o relacionados com estas cidades

DECLARE
Cursor c_duplicadas Is
  Select Nome,Uf, count(Nome) quantidade
  From Cidade 
  group by Nome,uf
  having count(Nome)>1;

Cursor Clientes(vNome_Cidade in VARCHAR2) is
  select cli.nome as Nome_Cliente, cid.nome as Nome_Cidade
  from cliente cli
  inner join cidade cid on cid.IDCidade = cli.IDCidade
  where cid.Nome = vNome_Cidade;
 
 BEGIN 
  
  FOR cidade IN c_duplicadas LOOP 
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    DBMS_OUTPUT.PUT_LINE(CIDADE.NOME);
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    FOR cliente in Clientes(cidade.Nome) LOOP        
        DBMS_OUTPUT.PUT_LINE(cliente.Nome_Cliente);        
    END LOOP;    
  END LOOP;  
END;