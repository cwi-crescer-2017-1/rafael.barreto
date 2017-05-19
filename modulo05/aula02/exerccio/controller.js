
var modulo = angular.module('instrutores',[]);


modulo.filter('aulaFilter',function(){
	return function(instrutor){
		
		let lpad = instrutor.numero > 10 ? '0' : '00'
		let numero = lpad + instrutor.numero 
		let aula = instrutor.aula.toUpperCase();

		return `${numero} - ${aula}`
	}
})

modulo.filter('mascada',function(){
    return function(dados){
        return nomeMascada =  dados.replace(/(nunes)/i,`$ $1 $`);         
    }
})


modulo.controller('instrutoresController',function($scope){	

			
			var instrutores = [

			  	{
				    nome: 'Pedro (PHP)',
				    aula: [{ numero: 3, nome: 'HTML e CSS' }]
			  	},
			    {
				    nome: 'Zanatta',
				    aula: [{numero: 5, nome: 'AngularJS' }]
			    },
			    {
			        nome: 'Bernardo',
			        aula: [{numero: 1,nome: 'OO'},{numero: 4, nome: 'Javascript'}]
			    },
			    {
				    nome: 'Nunes',
				    aula: [{ numero: 2, nome: 'Banco de Dados I' }]
				}
			];	
			
			
			let inst  = []

			instrutores.forEach( instrutor => 
				instrutor.aula.forEach(aula=> 
					inst.push({numero : aula.numero, aula : aula.nome ,nome : instrutor.nome }
			)))
				
				
				
			$scope.instrutores = inst;
})