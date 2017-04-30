------------- Exercicio 01 --------

SELECT	IDEmpregado as ID,
		NomeEmpregado asNome,
		DATEDIFF(year,DataNascimento , DataAdmissao) AS "Idade na admissao" -- verifica a diferenca entre as datas conforme especificado no primeiro parametro.
from empregado;



------------- Exercicio 02 --------

select top 1 ---- seleciona somente o primeiro resultado da busca
	   cargo,
	   count(1) quantidade
from empregado 
group by(cargo)
order by (quantidade) DESC

------------- Exercicio 03 --------

SELECT UF,
       count(uf) AS 'numero de cidades'
FROM cidade
GROUP BY(uf)
ORDER BY('numero de cidades') DESC

------------- Exercicio 04 --------

UPDATE empregado
SET IDDepartamento = 70
WHERE MONTH(DataAdmissao) = 12 and --- verifica o mes(MONTH) da data de admissao e compara para ver se e igual a 12
	  cargo != 'Atendente';


