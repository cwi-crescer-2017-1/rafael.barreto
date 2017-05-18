var modulo = angular.module('data',[])


modulo.controller('converteData',function($scope){

    $scope.converter = converter;
    
    function converter(){               
        let valoresData = $scope.dataDigitada.split("/");
        var dataFinal = new Date(valoresData[0] + '/' + valoresData[1] +'/' + valoresData[2]);       
        $scope.dataFinal = dataFinal;
    }
})