var modulo = angular.module("locadora",['ngRoute','auth']);

modulo.config(function($routeProvider){

        $routeProvider
            .when('/login',{
                controller: 'loginController',
                templateUrl : 'template/login.html'
            })

            .when('/cadastro',{
                controller : 'cadastroController',
                templateUrl : 'template/cadastro.html',
                resolve: {

                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                    autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/vendas',{
                controller : 'vendasController',
                templateUrl : 'template/vendas.html',
                resolve: {

                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                    autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/relatorio',{
                controller : 'relatoioController',
                templateUrl : 'template/relatorio.html',
                resolve: {

                // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                    autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                    }
                }
            })
            .otherwise('/login')
})

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:56293/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '#!/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '#!/cadastro',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '#!/login'
});