
modulo.controller('chatController',function($scope, $routeParams, mensagemService){

         $scope.meuUsuario = localStorage.getItem('usuario');


        //  funcoes internas


        function buscar(){
            buscarMensagem().then(function (response){
                  $scope.mensagens = response.data;  
            })
        }

        function postar(){
            enviarMensagem().then(function(response){
                buscar();
            })
        }
})