
modulo.controller('chatController',function($scope, $routeParams, mensagemService){

         $scope.meuUsuario = localStorage.getItem('usuario');

         function enviar(texto){

               let Usuario = { nome : localStorage.getItem('usuario') , foto : localStorage.getItem('foto')}   
               let mensagem = {Mensagen : texto , Usuario} ;
               postar(mensagem);
         }



        //  funcoes internas
        function buscar(){
            buscarMensagem().then(function (response){
                  $scope.mensagens = response.data;  
            })
        }

        function postar(mensagem){
            enviarMensagem().then(function(response){
                buscar();
            })
        }
})