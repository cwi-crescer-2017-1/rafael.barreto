
modulo.controller('homeController',function($scope,$routeParams,LivrosService){

        $scope.estaFechado = false;      
        $scope.livros
        $scope.lancamentosAberto = lancamentosAberto;
        $scope.buscar = Buscar;        
        $scope.lancamentos = lancamentos   
        $scope. ProximaPagina =  ProximaPagina;                    
        $scope.VoltarPagina = VoltarPagina;           

        function lancamentosAberto() {  
            $scope.estaFechado = !$scope.estaFechado;
        }

        function Buscar(pagina){  
            $scope.paginacao = pagina;          
            LivrosPorPagina(pagina);            
        }

        function ProximaPagina(){
            $scope.paginacao = $scope.paginacao < 1 ? 1 : $scope.paginacao;
             $scope.paginacao ++;
             LivrosPorPagina($scope.paginacao);
        }  

        function VoltarPagina(){
            debugger;
             $scope.paginacao --;
             LivrosPorPagina($scope.paginacao);
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