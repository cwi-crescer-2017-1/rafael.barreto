
modulo.factory('LivrosService',function($http){

        var url = "http://localhost:51875/api/livros";

        function verificarQuantidadeLivros(){
            return $http.get(`${url}/quantidade/livros`);
        }

        function obterLivrosPorPagina(pagina){         
            return $http.get(`${url}/pagina${pagina}`);            
        }

        function obterLancamentos(){
            return $http.get(`${url}/lancamentos`);
        }
        
        return {
            verificarQuantidadeLivros,
            obterLivrosPorPagina,
            obterLancamentos
        }

})