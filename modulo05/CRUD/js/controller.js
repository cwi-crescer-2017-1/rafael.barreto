var modulo = angular.module('app',[])


modulo.controller('instrutores', function($scope){

	$scope.incluirAula = incluirAula;
	$scope.alterarAula = alterarAula;	
	$scope.removerAula = removerAula;	
	$scope.cadastro = cadastro;	
	$scope.removerInstrutor = removerInstrutor;

	$scope.instrutores = [{		    
		    id: 0,                            // Gerado
		    nome: 'Nome',                     // Obrigatório (length = min 3, max 20)
		    sobrenome: 'Sobrenome',           // Opcional (length = max 30)
		    idade: 25,                        // Obrigatório (max 90)
		    email: 'email@cwi.com.br',        // Obrigatório (type=email)
		    dandoAula: true,                  // true ou false
		    aula: [1, 3],                     // Opcional (array)
		    urlFoto: 'http://foto.com/3.png'  // Opcional (porém tem uma default de livre escolha)
	  	}
	];

	$scope.aulas =[{ id:1 , nome : 'OO'},{id : 2, nome : 'HTML e CSS'},{id :3, nome :'Javascript'},{id : 4, nome : 'AngularJS'},{id : 5, nome :'Banco de Dados I'}];
	
	// funcoes de aulas

	function incluirAula(){	
		
		let nomesAulasDiferente = !$scope.aulas.filter(aula => aula.nome.toUpperCase() === $scope.novaAula.nome.toUpperCase()).length>0;

		if(nomesAulasDiferente){
			let idAula = $scope.aulas.length;			
			$scope.novaAula.id = idAula;		
			$scope.aulas.push($scope.novaAula);
			$scope.novaAula = {};
		}else{
			alert(' Aula ja Cadastrada ');
		}
	}	


	function alterarAula(){		

		$scope.aulas.forEach(a => a.id === parseInt($scope.idDoCampo) ? a.nome = $scope.aulaNovoNome : a.nome);		
	}


	function removerAula(){ ////// OK
		let eIgual;
		var	aulaCompara = $scope.aulas.filter(aula => aula.nome.toUpperCase() === $scope.aulaRemover.toUpperCase() ) ;
		aulaCompara.length > 0 ?  $scope.instrutores.forEach(instrutor => eIgual = instrutor.aula.filter(a => a === aulaCompara[0].id) >0) : false;		
		if(eIgual){
			alert(' Aula cadastrada para um Instrutor !!!');
		}else{

			$scope.aulas = $scope.aulas.filter(aula => aula.nome !== $scope.aulaRemover)
			$scope.aulaRemover = "";
		}		
					
	}

	// funcoes de Instrutores
	
	function cadastro(){

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
				$scope.instrutores.push($scope.novoInstrutor);			
				$scope.novoInstrutor = {};
			}else {
				alert('Nome ja Cadastrado');
			}
		}				
	}

	function removerInstrutor(){

		let instrutorNaoDandoAula = !$scope.instrutores[$scope.idRemover].dandoAula;
		
		if(instrutorNaoDandoAula){
			$scope.instrutores = $scope.instrutores.filter(i => i.id !== parseInt($scope.idRemover));
		}else{
			alert('instrutor Dando Aula');
		}
	}






	
})// fim da controller



// eIgual = $scope.instrutores[i].aula[j] === $scope.aulaRemover.toUpperCase() ?  eIgual = true : eIgual = false;



		// for(let i in $scope.instrutores){
		// 	for(let j in  $scope.instrutores[i].aula){						
				
		// 		eIgual = $scope.instrutores[i].aula[j]


		// 		if(eIgual) break;
		// 	}
		// }		

// )

// function showMyImage(fileInput) {
        
//         var files = fileInput.files;
//         for (var i = 0; i < files.length; i++) {           
//             var file = files[i];
//             var imageType = /image.*/;     
//             if (!file.type.match(imageType)) {
//                 continue;
//             }           
//             var img=document.getElementById("thumbnil");            
//             img.file = file;    
//             var reader = new FileReader();
//             reader.onload = (function(aImg) { 
//                 return function(e) { 
//                     aImg.src = e.target.result; 
//                 }; 
//             })(img);
//             reader.readAsDataURL(file);
//         }    
//     }
