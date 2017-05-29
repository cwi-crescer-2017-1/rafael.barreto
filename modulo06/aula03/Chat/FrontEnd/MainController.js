let modulo = angular.module('app',['ngRoute'])


modulo.config(function($routeProvider){

    $routeProvider
        .when('/index',{
            templateUrl: 'login.html'
        })
        .when('/chat',{
            templateUrl: 'chat.html'
        })
        .otherwise({
            redirectTo:'/index'
        })
})