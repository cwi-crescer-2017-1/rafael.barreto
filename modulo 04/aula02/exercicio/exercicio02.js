//------------  Exercicio 01 ------------------------

function verificaSerieInvalida(serie){

	var anoAtual = new Date().getFullYear();

	for(let i in serie){
		if(serie[i] === null || typeof serie[i] === "undefined"){	
			return true;
		}
	}

	if(serie.anoEstreia>anoAtual){
		return true;
	}
	return false;
}


function seriesInvalidas(series) {
	return series.filter(verificaSerieInvalida)
				 .map(series => series.titulo)
				 .toString();
}

console.log('exercicio 01');
console.log(seriesInvalidas(series));


// ----------- Exercicio 02 --------------------------

function filtraSeriesPorAno(serie,ano){	
	return serie.filter(serie => (serie.anoEstreia > ano))		   
}

console.log('exercicio 02 ');
console.log(filtraSeriesPorAno(series,2016));


//------------ Exercicio 03 -------------------------------


function mediaDeEpisodios(series){

	let mediaEpisodios = series.reduce((acc,serie) => (acc+serie.numeroEpisodios),0);
	mediaEpisodios = mediaEpisodios/series.length;	
	return mediaEpisodios;
}

console.log('exercicio03')

console.log(mediaDeEpisodios(series));


//------------ exercicio 04 -------------------------------


function procurarPorNome(series,nome){	

let nome1="";

	for(let i in series){
		nome1 = series[i].elenco.filter(elemento => elemento.includes(nome));
		if(nome1 > nome) return true;
	}

	return false;	

}

console.log('exercicio 04')	
console.log( procurarPorNome(series, "Winona"));

//------------- exercicio 05 -------------------------------

// Uma série tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor 
// total do salário a ser pago por mês para determinada série. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; 
// Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;


function mascadaEmSerie(serie){

	let gastoComDiretores = serie.diretor.length * 100000;
	let gastoFuncionarios = serie.elenco.length * 40000;
	let gastoTotal  = gastoComDiretores + gastoFuncionarios
	
	return gastoTotal;
}


console.log('exercicio 04')	
console.log( mascadaEmSerie(series[1]));



//------------- exercicio 06 -------------------------------

function queroGenero(series,genero){
	return series.filter(serie => serie.genero.indexOf(genero)>=0)
				 .map(series => series.titulo);	
}


function queroTitulo(series,titulo){

	return series.filter(serie => serie.titulo.toUpperCase().indexOf(titulo.toUpperCase())>=0)				 
				 .map(series => series.titulo);
}

console.log('exercicio 06');
console.log(queroGenero(series,"Caos"));
console.log(queroTitulo(series,"the"));

//------------- exercicio 07 -------------------------------

function ordenaSobrenome(a,b){  	
  	var nome = a.split(" ").slice(1).toString();
    var nome2 = b.split(" ").slice(1).toString()

    if ( nome < nome2 ) {
      return -1;
	}	  
	if (nome > nome2) {
	  return 1;
	}  	  
	return 0;	
}


function creditosIlluminatis(serie){

	let diretores = serie.diretor;
	let elenco = serie.elenco;

	diretores.sort(ordenaSobrenome);
	elenco.sort(ordenaSobrenome);
	
	console.log('-----------------------DIRETORES-------------------------')
	diretores.forEach(diretor => console.log((diretor)))
	console.log('-----------------------ELENCO-------------------------')
	elenco.forEach(elenco => console.log(elenco));
}

creditosIlluminatis(series[0]);


//------------- exerccio 08 -----------------------------------

// Serie Illuminati

// Escondemos um pequeno easter egg neste exercicio!
// Para que ele seja descoberto, será necessário algumas informações; Quando abreviamos um nome colocamos a primeira letra do nome seguida de um ponto final
// Exemplo:
// Bernardo Bosak Rezende -> Bernardo B. Rezende
// Augusto Schiller Wartchow -> Augusto S. Wartchow
// Essa é a informação básica! Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.
// Dica: Construa uma função separada para identificar se aquela String tem a abreviação;
// Show de bola, estamos quase lá!
// Uma vez achada a série, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas 
// (de preferência sem os pontos finais) em uma string que será retornada ao final do método.
// Forme uma hashtag com a palavra! #PALAVRA

// series[8].elenco[0].split(" ",2).slice(1) ----> separa a letra com .

//series[8].elenco.forEach(elenco => console.log(elenco.split(" ",2).slice(1)))// retorna todas letras do easter egg


 function verificaAbreviacao(serie){
 	let tamanhoElencoFiltrado = 0;
 	let tamanhoElenco

 	tamanhoElencoFiltrado = serie.elenco.filter(elenco => elenco.includes(".")).length;
 	tamanhoElenco = serie.elenco.length;

 	return tamanhoElenco === tamanhoElencoFiltrado;

 }


 function removePontos(string){
 	let palavraSemPonto = "";

 	for(let i = 0 ; i < string.length ; i++){
 		
 		palavraSemPonto += string[i] === "." ? "" : string[i];  
 	}
 	return palavraSemPonto;
 }
 
 
 function easterEgg(series){ 	
 	
 	var mensagen = "";
 	var serie = series.filter(verificaAbreviacao);

 	for(let i =0; i<serie.length; i++){
 		
 		for(let j =0 ; j < serie[i].elenco.length ; j++){

 			mensagen += serie[i].elenco[j].split(" ",2).slice(1);
 		}
 	} 

 	mensagen = removePontos(mensagen);		
 	return mensagen
 }	

console.log('--------------------- EASTER EGG ------------------------------')
console.log(easterEgg(series));