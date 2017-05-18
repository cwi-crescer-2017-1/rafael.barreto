var modulo = angular.module('data',[])

//--------------------- filtro feito no exercicio 02 ----------------
modulo.filter('mascada',function(){
    return function(dados){
        return nomeMascada =  dados.replace(/nunes/i,`$ ${dados} $`);         
    }
})

//-------------------------------------------------------------------

modulo.controller('converteData',function($scope){

    $scope.converter = converter; 
    
    function converter(){               
        let valoresData = $scope.dataDigitada.split("/");
        var dataFinal = new Date(valoresData[0] + '/' + valoresData[1] +'/' + valoresData[2]);       
        $scope.dataFinal = dataFinal;
    }
    //------------ exercicio 02 ------------------
           $scope.instrutores = [{
            nome: 'Bernardo',
            aula: [{
                numero: 1,
                nome: 'OO'
            },
            {
                numero: 4,
                nome: 'Javascript'
            }
            ]
        },
        {
            nome: 'Nunes',
            aula: [{
            numero: 2,
            nome: 'Banco de Dados I'
            }]
        },
        {
            nome: 'Pedro (PHP)',
            aula: [{
            numero: 3,
            nome: 'HTML e CSS'
            }]
        },
        {
            nome: 'Zanatta',
            aula: [{
            numero: 5,
            nome: 'AngularJS'
            }]
        }
        ];

    // ---------------- fim exercicio 02 ------------------
    
})

