
var modulo = angular.module('filtro',[]);

modulo.controller('Pokemons', function($scope){

	$scope.pokemon = [
		{
			nome: 'Pikachu', 
			tipo: 'Raio'
		},
		{
			nome: 'Charmander', 
			tipo: 'Fogo'
		},
		{
			nome: 'Squirtle', 
			tipo: 'Agua'
		},
		{
			nome: 'Bulbassauro', 
			tipo: 'Planta'
		},
		{
			nome: 'Pidgeoto', 
			tipo: 'Voador'
		},
		{
			nome: 'Butterfree', 
			tipo: 'Inseto'
		},
		{
			nome: 'Hitmonlee', 
			tipo: 'Lutador'
		},
		{
			nome: 'Gastly', 
			tipo: 'Fantasma'
		},
		{
			nome: 'Snorlax', 
			tipo: 'Normal'
		},
		{
			nome: 'Hipno', 
			tipo: 'Psiquico'
		},
		{
			nome: 'venonat', 
			tipo: 'Inseto'
		},
		{
			nome: 'Goku', 
			tipo: 'SSJ'
		},
		{
			nome: 'Batman', 
			tipo: 'Mito'
		},
		{
			nome: 'Chuck Norris', 
			tipo: 'Lendario'
		},
		{
			nome: 'DeadPool', 
			tipo: 'Zueiro'
		},
		{
			nome: 'Jirimon', 
			tipo: 'Vegetal'
		}
	]
	
})