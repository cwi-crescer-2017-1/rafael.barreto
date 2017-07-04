modulo.factory('homeService',function($http){
    
        let urlHome = "http://localhost:8080/usuario/";

        function buscarUsuarioLogado(email){
                return $http.get(`${urlHome}rsmennabarreto@gmailcom`);
        }

        function buscarPostagens(){
                return $http.get(`${urlHome}buscarpostagens`);
        }

        return{
             buscarUsuarioLogado,
             buscarPostagens
        }
})