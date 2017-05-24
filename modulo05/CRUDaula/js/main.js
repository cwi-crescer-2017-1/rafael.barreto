let modulo = angular.module('app',['ngRoute'])


modulo.config(function($routeProvider){
	
	$routeProvider
		.when('/index',{
			controller : 'instrutores',
			templateUrl: 'instrutores.html'
		})
		.when('/aulas',{
			controller : 'aulas',// utiliza o nome da controller
			templateUrl: 'aulas.html' 
		})		
		.otherwise({
			redirectTo: '/index'
    	});
})