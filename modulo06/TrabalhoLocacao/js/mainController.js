var modulo = angular.module("locadora",['ngRoute']);

modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                templateUrl : 'template/login.html'
            })
            .otherwise('/login')
})