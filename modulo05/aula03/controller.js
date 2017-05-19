var app = angular.module('app',[])


app.controller('incluirInstrutor',function($scope){

    $scope.incluir = incluir;

    let instrutores = [{
        nome: 'Bernardo',
        sobrenome:'Rezende',
        idade: 30,
        email: 'bernardo@cwi.com.br',
        jaDeuAula: true,
        aula: 'OO'
     }];

    let aulas = ['OO', 'HTML e CSS', 'Javascript', 'AngularJS', 'Banco de Dados I'];

    $scope.instrutores = instrutores;

    function incluir(nome,sobrenome,idade,email,jaDeuAula,aula){



        if($scope.formulario.$valid){
            instrutores.push({
                nome : nome, 
                sobrenome : sobrenome, 
                idade : idade, 
                email : email, 
                jaDeuAula : jaDeuAula, 
                aula : aula
            }); 
             console.log("bombo");           
        }                 
    }
})