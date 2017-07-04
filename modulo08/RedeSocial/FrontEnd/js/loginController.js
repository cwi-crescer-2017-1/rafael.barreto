
modulo.controller('loginController', function ($scope,$location,toastr,authService) {
   
    $scope.login = function (usuario) {
        debugger
        authService.login(usuario)
            .then(
            function (response) {                
                console.log(response);
                toastr.success('Login com sucesso!','Redirecionando');
                $location.path('/home');

            },
            function (response) {
                console.log(response);
                toastr.error('Erro no Login!');
            });
    };
})