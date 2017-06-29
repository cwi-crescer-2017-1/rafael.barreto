var modulo = angular.module("plusUltra",[]);


modulo.config(function($routerProvider){

        $routerProvider
            .when('/login',{
                templateUrl : 'template/login.html'
            })
            .when('/cadastro',{
                templateUrl : 'template/cadastro.html'
            })
            .otherwise('/login')
})