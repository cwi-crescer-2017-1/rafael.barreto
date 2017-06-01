let modulo = angular.module('biblioteca',['ngRoute'])

modulo.config(function($routeProvider){

        $routeProvider
            .when('/index',{
                controller : 'js/homeController',
                templateUrl : 'template/home'                
            })
})