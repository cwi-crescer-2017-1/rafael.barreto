console.log("go!");


if(typeof pi !== "undefined"){
    console.log(pi);
}

//es 2015 --> procurar nao usar isto
var somado = (a,b) => a+b
console.log("somado" , somado(1,2));


function somaSemReturn(a, b) {
  return a + b;
}

console.log("teste",somaSemReturn(1,2));

var somar = function(a, b){
  return a+b;
}
console.log("soma " , somar(1,2));

var resultado = (function (a,b){
      return a*b;
})(2,3);

console.log(resultado);
