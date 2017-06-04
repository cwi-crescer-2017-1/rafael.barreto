
modulo.controller('homeController',function($scope){

        $scope.estaFechado = false;
        $scope.lancamentosAberto = lancamentosAberto;

        function lancamentosAberto() {  
            $scope.estaFechado = !$scope.estaFechado;
        };


        
})