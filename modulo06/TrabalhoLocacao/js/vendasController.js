
modulo.controller('vendasController',function($scope,$routeParams,$rootScope,clienteService){

         $rootScope.mostrar = true;
         $scope.ListarClientes = ListarClientes
         ListarClientes();
         buscarProdutos();
         buscarPacotes();
         buscarAdicionais();

        function ListarClientes(){
            buscarClientes();
        }
        

         //funcoes internas

         function buscarClientes(){
             clienteService.Buscar().then(function(response){
                 $scope.Clientes = response.data.dados;
                 console.log($scope.Clientes);
             })
         }

         function buscarProdutos(){
                clienteService.BuscarProduto().then(function(response){
                    $scope.produtos = response.data.dados;
                })
         }

         function buscarPacotes(){
             clienteService.BuscarPacote().then(function(response){
                 $scope.pacotes = response.data.dados;
             })
         }

         function buscarAdicionais(){
             clienteService.BuscarAdicionais().then(function(response){
                 $scope.Adicionais = response.data.dados;
             })
         }

})