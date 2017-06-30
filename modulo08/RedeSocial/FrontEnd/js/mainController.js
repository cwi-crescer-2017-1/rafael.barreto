var modulo = angular.module("plusUltra",['ngRoute']);


modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                templateUrl : 'template/login.html'
            })
            .when('/cadastro',{
                templateUrl : 'template/cadastro.html'
            })
            .otherwise('/login')
})