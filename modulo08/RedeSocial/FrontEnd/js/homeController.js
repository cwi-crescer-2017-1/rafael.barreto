

modulo.controller("homeController",function($scope,homeService){
     buscarLogado();         

    function buscarLogado(email){
        homeService.buscarUsuarioLogado(email).then(function(response){
            $scope.dados = response.data;                    
        })
    }

    function buscarPostagem(){
        homeService.buscarPostagens().then(function(response){
            $scope.postagens = response.data;
        })
    }
})