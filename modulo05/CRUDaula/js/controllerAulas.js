modulo.controller('aulas',function($scope, $routeParams, aulasService){

    $scope.incluirAula = incluirAula;
	$scope.alterarAula = alterarAula;	
	$scope.removerAula = removerAula;	
    var aulaID=0;    
    listar();

    function incluirAula(){
        criar($scope.novaAula);
        $scope.novaAula = {};       
    }	


    function alterarAula(index){
        console.log($scope.aulaNovoNome)
        console.log($scope.aulaAtualizar)        
        debugger
        $scope.aulaAtualizar.nome = $scope.aulaNovoNome;      
    }

    function removerAula(index){ 		
        remover($scope.aulas[index]);
    }    

    // --------------------funcoes internas
    
    function listar(){	   
        aulasService.listar().then(function(response){
		    $scope.aulas = response.data;
	    })
    }   

	function criar(aula){
		aulasService.criar(aula).then(function(){
			listar();
		})
	}

	function atualizara(aula){
		aulasService.atualizar(aula).then(function(){
			listar();
		})
	}

    function remover(aula){
        aulasService.removerAula(aula).then(function(){
            listar();      
        })
    }
})