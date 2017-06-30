

modulo.controller("CadastroController",function($scope,UsuarioService){

        $scope.Cadastrar = Cadastrar;        

        function Cadastrar(usuario){    
            debugger        
            UsuarioService.Cadastrar(usuario).then(function(response){
                 toastr.success('Cadastrado com sucesso', 'Toastr fun!');
            })
        }

})