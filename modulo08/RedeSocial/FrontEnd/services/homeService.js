modulo.factory('homeService',function($http){
    
        let urlHome = "http://localhost:8080/usuario/";

        function buscarUsuarioLogado(email){
                return $http.post(`${urlHome}buscarUsuario`,email);
        }

        function buscarPostagens(){
                return $http.get(`${urlHome}buscarpostagens`);
        }

        function fazerPost(post){
                return $http.post(`${urlHome}post`,post);
        }

        return{
             buscarUsuarioLogado,
             buscarPostagens,
             fazerPost
        }
})