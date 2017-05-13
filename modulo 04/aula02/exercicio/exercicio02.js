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


function contemTexto(series,nome){	

let nome1="";

	for(let i in series){
		nome1 = series[i].elenco.find((elemento,id,array) => elemento === nome);
		if(nome1 == nome) return true;
	}

	return false;	

}

console.log('exercicio 04')	
console.log( contemTexto(series, "Winona Ryder"));

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



//------------- exercicio 05 -------------------------------







