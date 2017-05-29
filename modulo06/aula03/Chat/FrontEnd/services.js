
modulo.factory('mensagemService',function($http){

        url = 'http://localhost:54298/api/mensagem';

        function getMensagem(){
              return $http.get(url); 
        }

        function enviarMensagem(mensagem){
              return $http.post(url,mensagem)  
        }

        return{
            enviarMensagem,
            buscarMensagem: getMensagem    
        }
})