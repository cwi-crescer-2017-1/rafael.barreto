

modulo.controller('cadastroController',function($scope,$rootScope,$routeParams,clienteService){

        $rootScope.mostrar = true;
        $scope.cadastrarcliente = cadastrarcliente
        $scope.cliente;

        function cadastrarcliente(cliente){            
            cadastrar(cliente);
            setTimeout(function(){ $scope.mensagem =' ' ; }, 3000);            
            $scope.cliente = {};                        
        }

        //funcoes internas
        
        function cadastrar(cliente){
            clienteService.cadastrar(cliente).then(function(response){
                $scope.mensagem = response.data.mensagem;
            })
        }

})