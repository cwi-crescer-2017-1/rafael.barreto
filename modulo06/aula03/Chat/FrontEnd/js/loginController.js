
modulo.controller('login',function($scope, $routeParams ){

         $scope.cadastrar = cadastrar;         
        
        function cadastrar(nome,url){
            debugger;
            localStorage.setItem('usuario',nome);
            localStorage.setItem('foto',url);           
        }
})