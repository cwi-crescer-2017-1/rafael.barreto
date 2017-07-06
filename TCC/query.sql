
----- criacao banco ---------------


  Create tablespace GENESIS 
  datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\GENESIS.dbf' 
  size 100m 
  autoextend on 
  next 100m 
  maxsize 2048m;

Create user GENESIS identified by GENESIS default tablespace GENESIS;
grant connect, resource, create view to AULAJAVA;


---- criacao tabelas ------------

CREATE TABLE COLABORADOR(
        
        ID_COLABORADOR     NUMBER(12),
        NOME               VARCHAR2(100),
        EMAIL              VARCHAR2(100),
        DATA_NASCIMENTO    DATE
        DATA_ADMISSAO      DATE
        DATA_DEMISSAO      DATE
        SEDE               VARCHAR2(50),
        RAMAL              NUMBER(20),
        ANDAR              NUMBER(40),
        POSICAO         
        DESCRICAO          VARCHAR2(400),
        DESCRICAO_RESUMIDA VARCHAR2(100),
        TIPO_USUARIO       VARCHAR2(100),
        SITUACAO           NUMBER(1),
        TAG                VARCHAR2(100),
        ID_TIME            NUMBER(12),        
)


CREATE TABLE COLABORADOR_FEITO(
    ID_COLABORADOR_FEITO NUMBER(12),
    ID_COLABORADOR NUMBER(12),
    ID_FEITO NUMBER(12)
);

CREATE INDEX INDICE_COLABORADOR_FEITO ON COLABORADOR_FEITO (ID_COLABORADOR,ID_FEITO);

CREATE TABLE FEITO(
    ID_FEITO           NUMBER(12)
    NOME                VARCHAR2(100),
    DESCRICAO           VARCHAR2(400),
    DESCRICAO_RESUMIDA  VARCHAR2(100),
    URL_IMAGEM          VARCHAR2,
);

CREATE TABLE TIME(
    ID_TIME            NUMBER(12)
    NOME               VARCHAR2(100),  
    DESCRICAO          VARCHAR2(400),
    DESCRICAO_RESUMIDA VARCHAR2(100),
    SITUACAO           
    MENBROS  ---> NxN
);


CREATE TABLE LIKE(
    ID_LIKE
);


COMMIT