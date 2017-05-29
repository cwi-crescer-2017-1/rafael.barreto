
modulo.controller('login',function($scope, $routeParams ){

         $scope.cadastrar = cadastrar;         
        
        function cadastrar(nome,url){            
            localStorage.setItem('usuario',nome);
            localStorage.setItem('foto',url);           
        }
})