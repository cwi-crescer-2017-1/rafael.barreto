
modulo.controller('instrutores', function($scope ,$routeParams ,instrutorService, aulasService){

	
	$scope.cadastro = cadastro;	
	$scope.remover = remover;	
	$scope.instrutorAdicionarAula = instrutorAdicionarAula;	
	$scope.instrutores = []	 
	listarAulas();


	function cadastro(){
		if($scope.cadastroInstrutores.$valid){
			$scope.novoInstrutor.urlFoto === undefined ? $scope.novoInstrutor.urlFoto = 'imagens/imagenPadrao.png' : $scope.novoInstrutor.urlFoto ;				
			$scope.nomeDaAula ="";
			criar($scope.novoInstrutor);			
			debugger
			$scope.novoInstrutor = {aula: []}									
		}
							
	}
	
	function remover(index){
		excluir($scope.instrutores[index]); //$scope.instrutores.splice(index,1);			
	}	

	function instrutorAdicionarAula(){		
		$scope.nomeDaAula === undefined ? 
			$scope.nomeDaAula = $scope.selecao.nome : 
			$scope.nomeDaAula = $scope.nomeDaAula+'-'+$scope.selecao.nome ;	
		$scope.novoInstrutor.aula === undefined ? $scope.novoInstrutor.aula =[] : $scope.novoInstrutor;
		$scope.novoInstrutor.aula.push($scope.selecao.id)
		$scope.novoInstrutor.aula

	}

//--------------- funcoes internas -------------------
	function criar(instrutor){
		instrutorService.criarInstrutor(instrutor).then(function(){
			listar();
		});		
	}

	function excluir(instrutor){
		instrutorService.removerInstrutor(instrutor).then(function(){
			listar();
		})
	}	

	function listar(){
		instrutorService.listar().then(function (response){
			$scope.instrutores = response.data;			
		});
	}

	 function listarAulas(){	   
        aulasService.listar().then(function(response){
		    $scope.aulas = response.data;
	    })
    }	
})