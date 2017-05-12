
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
var total=0;

function adicionar(numero){      
     function soma (numero2){
        return numero+numero2
     }
     return soma;
}


console.log(adicionar(3)(4));
console.log(adicionar(5642)(8749));

//------------------------ exercicio 05 -------------------------------------

function fiboSum(valor){
  // 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
  var soma = 1;
  var numero = 0;
  var numero2 = 1; 
  var total=1;

  for(var x = 1; x < valor; x++){    

    soma = numero+numero2;
    numero = numero2;
    numero2 = soma; 

    total += soma;    
  }
  console.log(total);    
}

fiboSum(7);

//---------------------- Exercicio 06 ---------------------------------------


function queroCafe(mascada , precos){

    var troca;
    var precosAbaixo = [];

    for(var x = 0; x<precos.length;x++){

      if(precos[x] <= mascada){
        precosAbaixo.push(precos[x]);
      }
    }

    for(var i = 0; i < precosAbaixo.length ; i++){
      for(var j = 0 ; j< precosAbaixo.length; j++){

        if(precosAbaixo[i]<precosAbaixo[j]){              
          
          troca = precosAbaixo[j];
          precosAbaixo[j] = precosAbaixo[i];
          precosAbaixo[i] = troca
        }
      }
    }    
    console.log(precosAbaixo);
}

queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
