//1. Escreva uma função para números serem arredondados de acordo com o número de casas decimais
//parametrizado. Caso nada seja informado assuma 2 casas. Retorne um número.

Number.prototype.arrendondaAi = function (casasDecimais){
        casasDecimais = casasDecimais || 2;
        let numero = Math.pow(10,casasDecimais);
        return Math.round(this*numero)/numero;
}

////------------------------------- aula ---------------------------
