var modulo = angular.module("plusUltra",['ngRoute','toastr','auth']);


modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                templateUrl : 'template/login.html'                
            })
            .when('/cadastro',{
                templateUrl : 'template/cadastro.html',
                controller : 'CadastroController'
            })
            .when('/home',{
                templateUrl : 'template/home.html',
                // resolve: {
                // // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                //     autenticado: function (authService) {
                //     return authService.isAutenticadoPromise();
                //     }	
                // }
            })
            .otherwise('/login')
})