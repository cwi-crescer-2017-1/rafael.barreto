/*Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve monitorar tanto as 
apostas quanto os números de cada aposta.*/

Create table Log_Aposta (
  IDLog_Aposta        integer not null,
  id_Aposta_antigo    integer,
  id_Aposta_novo      integer,
  Id_concurso_antigo  integer,
  id_Concurso_Novo    integer,
  Data           date default sysdate,  
  Operacao       char(1) not null,
  constraint PK_Log_Aposta 
  primary key (IDLog_Aposta)
);

Create sequence sqLog_Aposta; 

Create table Log_Numeros (
  IDLog_Numeros    integer not null,
  id_Aposta_novo   integer,
  id_Aposta_antigo integer,
  numero_antigo    integer,
  numero_novo      integer,
  Data             date default sysdate,  
  Operacao         char(1) not null,
  constraint PK_Log_Numeros 
  primary key (Log_Numeros)
);

Create sequence Log_Numeros;

create or replace
trigger TR_AUD_Aposta
    after insert or update or delete on APOSTA
Declare
  v_operacao          char(1);
  v_IdAposta_novo     integer;
  v_idAposta_antigo   integer;
  v_IdConcurso        integer;
  v_idConcurso_antigo integer;
Begin
  if INSERTING then
     v_operacao := 'I';
     v_idAposta_novo := new.IdAposta;
     v_idAposta_antigo := null;
     v_idConcurso_novo := new.IdConcurso;
     v_idConcurso_antigo := null;
  elsif UPDATING then
     v_operacao := 'U';
     v_idAposta_novo := new.IdAposta;
     v_idAposta_antigo := old.IdAposta;
     v_idConcurso_novo := new.IdConcurso;
     v_idConcurso_antigo := old.IdConcurso;
  else
     v_operacao := 'D';
     v_idAposta_novo := new.IdAposta;
     v_idAposta_antigo := old.IdAposta;
     v_idConcurso_novo := new.IdConcurso;
     v_idConcurso_antigo := old.IdConcurso;
  end if;
  Insert into Log_Aposta (IDLog_Aposta, id_Aposta_antigo,idAposta_novo, idConcurso_novo, idConcurso_antigo, data,operacao)
      values (sqLog_Aposta.nextval,v_idAposta_antigo,v_idAposta_novo,v_idConcurso_novo,v_idConcurso_antigo,sysdate,v_operacao);
End TR_AUD_Aposta;