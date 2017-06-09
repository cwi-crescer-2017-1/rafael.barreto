
modulo.controller('vendasController',function($scope,$routeParams,$rootScope,clienteService,$localStorage){

         $rootScope.mostrar = true;
         $scope.ListarClientes = ListarClientes;
         $scope.NovaLocacao = NovaLocacao;
         $scope.valorTotal = valorTotal;         

         ListarClientes();
         buscarProdutos();
         buscarPacotes();
         buscarAdicionais();

        function ListarClientes(){
            buscarClientes();
        }   

        function NovaLocacao(NovaLocacao){           
            criarLocacao(NovaLocacao);
        }     

        function valorTotal(adicionais,preco){
            let total = preco || 0;
            if(!angular.isArray(adicionais))
                return total;
            
            adicionais.forEach( item => total += item.Preco);
            return total;

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

         function criarLocacao(locacao){
             clienteService.CadastraLocacao(locacao).then(function(response){
                 $scope.mensagem = response.data.dados;
             })
         }
})