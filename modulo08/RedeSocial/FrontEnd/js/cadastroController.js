

modulo.controller("CadastroController",function($scope,$location,UsuarioService,toastr){

        $scope.Cadastrar = Cadastrar;        

        function Cadastrar(usuario){                     
            UsuarioService.Cadastrar(usuario).then(function(response){
                 toastr.success('Cadastrado com sucesso', 'Sucesso');
                 $location.path('/login');
            })
        }
})