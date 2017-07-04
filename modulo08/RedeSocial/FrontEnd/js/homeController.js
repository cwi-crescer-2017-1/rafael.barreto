

modulo.controller("homeController",function($scope,homeService,authService,$location,toastr){
     $scope.logout = logout;
     $scope.postar = postar;

     buscarLogado();
     buscarPostagem();              

    function buscarLogado(usuario){
        usuario = { email : authService.getUsuario().username };
        homeService.buscarUsuarioLogado(usuario).then(function(response){                       
            $scope.dados = response.data;                    
        })
    }

    function buscarPostagem(){
        homeService.buscarPostagens().then(function(response){
            $scope.postagens = response.data; 
            buscarPostagem(); 
            console.log(response.data);          
        })
    }

    function postar(postagem){
        postagem.email = authService.getUsuario().username;
        debugger;
        homeService.fazerPost(postagem).then(function(response){
            toastr.info('Post feito com sucesso','Postado');
        })
    }

    function logout(){
        authService.logout();
        $location.path('/login');
    }
    
})