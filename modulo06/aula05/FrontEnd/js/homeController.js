
modulo.controller('homeController',function($scope){

        $scope.parametros = {
        BuscarLivros: 8,
        PularLivros: pagina * 8
        };

        $http({ 
            url: 'http://localhost:1234/api/livros', 
            method: 'GET', 
            params: parametros 
            }) 
            .then(function (response) { 
            $scope.livros = response.data.dados; 
        });       

})