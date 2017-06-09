
modulo.controller('loginController',function($scope,$rootScope,$location, authService){
        $rootScope.mostrar = false;
        $scope.usuario;

        $scope.logout = function(){
                 authService.logout();
        }    
        
        $scope.login = function (usuario) {        
        authService.login(usuario)
        .then(
                function (response) {
                console.log(response);
                alert("Logado!");
                $location.path('/vendas');                
                },      
                function (response) {
                alert("Erro!");
                });
         };
})