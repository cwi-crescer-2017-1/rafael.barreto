
modulo.controller('chatController',function($scope, $routeParams, mensagemService){

         $scope.meuUsuario = localStorage.getItem('usuario');
         $scope.meuUsuarioFoto = localStorage.getItem('foto');
         $scope.enviar = enviar;

         setInterval(function(){ buscar(); }, 1000);


         function enviar(texto){
               let Usuario = { Nome : localStorage.getItem('usuario') , Foto : localStorage.getItem('foto')}   
               let mensagem = {Mensagen : texto , Usuario} ;
               postar(mensagem);
               $scope.mensagenTexto ="";
         }



        //  funcoes internas
        function buscar(){
            mensagemService.buscarMensagem().then(function (response){
                  $scope.mensagens = response.data;                  
            })
        }

        function postar(mensagem){     
            debugger       
            mensagemService.enviarMensagem(mensagem).then(function(){
                buscar();
            })
        }
})