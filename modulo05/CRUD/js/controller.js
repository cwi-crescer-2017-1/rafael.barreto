var modulo = angular.module('app',[])


modulo.controller('instrutores', function($scope){

	$scope.incluirAula = incluirAula;
	$scope.alterarAula = alterarAula;	
	$scope.removerAula = removerAula;	
	$scope.cadastro = cadastro;	
	$scope.removerInstrutor = removerInstrutor;
	$scope.instrutorAdicionarAula = instrutorAdicionarAula;
	var aulaID=0;
	
 
	$scope.instrutores = [
	];

	$scope.novoInstrutor = {
		id : undefined,
		nome : undefined,
		sobrenome : undefined,
		idade: undefined,
		email : undefined,
		dandoAula : false,
		aula: [],
		urlFoto : undefined
	}

	$scope.aulas =[{ id:1 , nome : 'OO'},{id : 2, nome : 'HTML e CSS'},{id :3, nome :'Javascript'},{id : 4, nome : 'AngularJS'},{id : 5, nome :'Banco de Dados I'}];
	
	// funcoes de aulas

	function incluirAula(){	
		
		let nomesAulasDiferente = !$scope.aulas.filter(aula => aula.nome.toUpperCase() === $scope.novaAula.nome.toUpperCase()).length>0;

		if(nomesAulasDiferente){
			let idAula = $scope.aulas.length +1;
			$scope.novaAula.id = idAula;		
			$scope.aulas.push($scope.novaAula);
			$scope.novaAula = {};
		}else{
			alert(' Aula ja Cadastrada ');
		}
	}	


	function alterarAula(){	
		$scope.aulas.forEach(a => a.nome === $scope.nomeDoCampo ? a.nome = $scope.aulaNovoNome : a.nome);
		console.log($scope.nomeDoCampo)

	}


	
	function removerAula(index){ 		
		let podeRemover
		
		if($scope.instrutores.length === 0) podeRemover=true;
		else $scope.instrutores.forEach(i => podeRemover = i.aula.filter(a => a.nome.toUpperCase() === $scope.aulas[index].nome.toUpperCase()).length===0)

		podeRemover ? $scope.aulas.splice(index,1) : alert('aula sendo ministrada por um instrutor');						
	}


	// funcoes de Instrutores
	
	
	function cadastro(){

		console.log($scope.email)

		if($scope.cadastroInstrutores.$valid){
				
			$scope.novoInstrutor.id = $scope.instrutores.length
			let nomesDiferentes = !$scope.instrutores.some(i => i.nome.toUpperCase() === $scope.novoInstrutor.nome.toUpperCase())
			let sobrenomesDiferentes;
			let emailIgual = $scope.instrutores.some(i => i.email.toUpperCase() === $scope.novoInstrutor.email.toUpperCase())

			emailIgual ? alert('Email ja Cadastrado') : emailIgual;
			
			if($scope.novoInstrutor.sobrenome !== undefined ){
				sobrenomesDiferentes = !$scope.instrutores.some(i => i.sobrenome.toUpperCase() === $scope.novoInstrutor.sobrenome.toUpperCase())
			}else {
				$scope.instrutores.sobrenome = " ";
			}			

			if(nomesDiferentes || sobrenomesDiferentes && $scope.email.$valid && $scope.email.$not-empty){

				$scope.novoInstrutor.urlFoto === undefined ? $scope.novoInstrutor.urlFoto = 'imagens/imagenPadrao.png' : $scope.novoInstrutor.urlFoto ;
				$scope.instrutores.push($scope.novoInstrutor);			
				$scope.novoInstrutor = {aula: []}				
				console.log($scope.Instrutores);

			}else {
				alert('Nome ja Cadastrado');
			}
		}				
	}



	function removerInstrutor(index){
		if(!$scope.instrutores[index].dandoAula) $scope.instrutores.splice(index,1);		
		else alert('Instrutor dando Aula');
	}	

	function instrutorAdicionarAula(){	
		$scope.selecao === undefined ? $scope.selecao : $scope.novoInstrutor.aula.push({id: aulaID,nome:$scope.selecao});
		console.log($scope.selecao);
		aulaID++;
	}
})// fim da controller



// instrutores = [{         
//         id: 0,                            // Gerado 
//         nome: 'Nome',                     // Obrigatório (length = min 3, max 20) 
//         sobrenome: 'Sobrenome',           // Opcional (length = max 30) 
//         idade: 25,                        // Obrigatório (max 90) 
//         email: 'email@cwi.com.br',        // Obrigatório (type=email) 
//         dandoAula: true,                  // true ou false 
//         aula: [1, 3],                     // Opcional (array) 
//         urlFoto: 'http://foto.com/3.png'  // Opcional (porém tem uma default de livre escolha) 
//      }]

// function removerAula(){ 
// 		let eIgual;
// 		var	aulaCompara = $scope.aulas.filter(aula => aula.nome.toUpperCase() === $scope.aulaRemover.toUpperCase() ) ;
// 		console.log($scope.instrutores)
// 		console.log(aulaCompara[0].id)
		
// 		aulaCompara.length > 0 ?  $scope.instrutores.forEach(instrutor => eIgual = instrutor.aula.filter(a => a.nome.toUpperCase() === aulaCompara[0].nome.toUpperCase()) >0) : false;		
		
// 		if(eIgual){
// 			alert(' Aula cadastrada para um Instrutor !!!');
// 		}else{
// 			$scope.aulas = $scope.aulas.filter(aula => aula.nome !== $scope.aulaRemover)
// 			$scope.aulaRemover = "";
// 		}							
// 	}
