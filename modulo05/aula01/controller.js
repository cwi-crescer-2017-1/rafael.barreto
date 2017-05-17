
var modulo = angular.module('aula01',[]);

modulo.controller('pokemon',function($scope){    
    $scope.pokemon = {
        nome : 'pikachu',
        descricao : 'da choque'        
    }
})