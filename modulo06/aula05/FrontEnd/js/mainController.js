let modulo = angular.module('biblioteca',['ngRoute'])

modulo.config(function($routeProvider){

        $routeProvider
            .when('/homeController',{
                controller : 'home',//utilizar somente nome do controller
                templateUrl : 'template/home.html'                
            })
            .otherwise('/home');
})