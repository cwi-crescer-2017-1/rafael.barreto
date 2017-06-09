
modulo.factory('clienteService',function($http){

        urlCliente = 'http://localhost:56293/api/clientes/'
        urlLocacoes = 'http://localhost:56293/api/locacoes/'

        function CadastraCliente(cliente){
            return $http.post(`${urlCliente}cadastrar`,cliente);
        }

        function BuscarClientes(){            
            return $http.get(`${urlCliente}listar`);
        }
        
        //--------- locacao ------------------------

        function CadastraLocacao(locacao){
            return $http.post(`${urlLocacoes}cadastrar`,locacao);
        }

        function BuscarProduto(){
            return $http.get(`${urlLocacoes}produtos`)
        }   

        function BuscarPacote(){
            return $http.get(`${urlLocacoes}pacotes`)
        }

        function BuscarAdicionais(){
            return $http.get(`${urlLocacoes}Adicionais`)
        }

        function RelatorioMensal(data){
            return $http.get(`${urlLocacoes}relatorios/${data.toISOString().split('T')[0]}`);
        }
        
        return{
            cadastrar : CadastraCliente,
            Buscar: BuscarClientes,
            BuscarProduto,
            BuscarPacote,
            BuscarAdicionais,
            CadastraLocacao,
        }
})