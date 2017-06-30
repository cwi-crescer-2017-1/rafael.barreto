var modulo = angular.module("plusUltra",['ngRoute','toastr']);


modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                templateUrl : 'template/login.html'                
            })
            .when('/cadastro',{
                templateUrl : 'template/cadastro.html',
                controller : 'CadastroController'
            })
            .otherwise('/login')
})