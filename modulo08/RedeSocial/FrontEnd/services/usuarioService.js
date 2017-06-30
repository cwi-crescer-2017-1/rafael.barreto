

modulo.factory('UsuarioService',function($http){
    
        let urlUsuario = "http://localhost:8080/usuario";        

        function Cadastrar(usuario){
                return $http.post(`${urlUsuario}/novo`, usuario, {headers: {'Content-Type': 'application/json'} });
        }

        return{
                Cadastrar
        }
})