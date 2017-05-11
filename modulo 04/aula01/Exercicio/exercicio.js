
//------------------- exercicio 01 -------------------------------------

function daisyGame(petalas){
    return petalas = petalas % 2 === 0 ? "Love me to" : "Love me not";
}

console.log(daisyGame(0));
console.log(daisyGame(1));

//------------------------ exercicio 02 ---------------------------------


function maiorTexto(nomes){
  var  maior ="";
    for(var nome in nomes){
      maior = maior.length > nomes[nome].length ? maior : nomes[nome];
  }
  return maior;
}

var nomes = [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ];

console.log(maiorTexto(nomes));

//--------------------- exercicio 03 ---------------------------------------

function imprimeNomes(nomes){
  for(var nome in nomes){
    console.log(" ola querido instrutor : ",nomes[nome]);
  }
}

function imprime(nomes,funcao){
      if(typeof funcao === "function"){
        funcao(nomes);
      }else{
        alert(" DEU JABULANIIII NAO FACA ISSOOOOOOO")
      }
}

imprime(nomes,imprimeNomes);

//------------------------- exercicio 04 ------------------------------------


function adicionar(){ function (numero){
      return numero;
    };

console.log();
