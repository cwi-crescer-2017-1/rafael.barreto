

modulo.controller('relatoioController',function($scope,$rootScope,$localStorage,clienteService){

        $rootScope.mostrar = true;
        $scope.RelatorioPorData = RelatorioPorData;
        $scope.listarEmAberto = listarEmAberto;
        $scope.Devolver  = Devolver;

        
        function Devolver(relatorio){
                debugger
                clienteService.Devolucao(relatorio).then(function(response){
                      listarEmAberto();  
                })
        }

        function RelatorioPorData(data){
                debugger
                clienteService.RelatorioMensal(data).then(function(response){
                        $scope.relatorios = response.data.dados;
                })
        }

        function listarEmAberto(){
                clienteService.relatorioEmaberto().then(function(response){
                        debugger;
                        $scope.relatorios = response.data.dados;
                })
        }
})