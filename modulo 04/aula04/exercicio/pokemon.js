// Crie um arquivo pokesearch.html (com javascript incluído) e implemente o evento de click do 
// botão para pesquisar pelo pokémon a partir do número digitado no input. No retorno da requisição, renderize dentro de uma div as seguintes informações do pokémon:

// Número
// Nome
// Sprite principal do pokémon (front_default)
// Lista de descrições tipos (pode ser um elemento <ul>)
// Fique à vontade para estilizar a página como desejar. Compartilhe no slack com seus colegas!


function pokesearch(){

	let posicaoPokemon = document.getElementById("texto-busca").value;
	let url = `http://pokeapi.co/api/v2/pokemon/${posicaoPokemon}/`

	


	fetch(url)
		.then(response => response.json())
		.then(json => {
			console.log(json);			

			let nome = document.getElementById("nome");			
			let imagem = document.getElementById("imagem-pokemon");
			let dadosTipo = document.getElementById("dados-tipo");
			let dadosAltura = document.getElementById("dados-altura");
			let dadosPeso = document.getElementById("dados-peso");
			let dadosHabilidade	= document.getElementById("dados-habilidade");
			let img = document.createElement('img');	

			imagem.innerText = "";
			nome.innerText = posicaoPokemon + " " + json.name;			
			img.setAttribute('src',json.sprites.front_default);			
			imagem.append(img);
			dadosTipo.append(" " + json.types[0].type.name);
			dadosAltura.append(" " + json.height);
			dadosPeso.append(" " + json.weight);
			dadosHabilidade.append(" " + json.abilities[1].ability.name);

		})	


	function limparCampos(){
		imagem.innerText = "";
		dadosTipo.innerText = "";
		dadosAltura.innerText = "";
		dadosPeso.innerText = "";
		dadosHabilidade.innerText = "";
	}
}



