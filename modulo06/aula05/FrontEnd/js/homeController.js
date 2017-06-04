
modulo.controller('homeController',function($scope,$routeParams,LivrosService){

        $scope.estaFechado = false;
        $scope.livros
        $scope.lancamentosAberto = lancamentosAberto;
        $scope.Buscar = Buscar;
        $scope.lancamentos                
        lancamentos()
        Buscar(1)


        function lancamentosAberto() {  
            $scope.estaFechado = !$scope.estaFechado;
        };

        function Buscar(pagina){
            LivrosPorPagina(pagina);
            console.log($scope.livros);
            
        }   
        // Funcoes internas

      function LivrosPorPagina(pagina){        
            LivrosService.obterLivrosPorPagina(pagina).then(function(response){ 
                $scope.livros = response.data;                               
            })            
      } 

      function lancamentos(){
          LivrosService.obterLancamentos().then(function(response){
                $scope.lancamentos = response.data;              
          })
      } 

})


// 