var modulo = angular.module("locadora",['ngRoute']);

modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                controller: 'loginController',
                templateUrl : 'template/login.html'
            })

            .when('/cadastro',{
                controller : 'cadastroController',
                templateUrl : 'template/cadastro.html'
            })
            .when('/vendas',{
                controller : 'vendasController',
                templateUrl : 'template/vendas.html'
            })

            .otherwise('/login')
})