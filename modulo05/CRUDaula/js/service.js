
modulo.factory('aulasService',function($http){

     url = 'http://localhost:3000/';     

     function getAulas(){        
         return $http.get(`${url}aula`);
     }

     function getAulasPorId(id){
         return $http.get(`${url}aula/${id}`);
     }

     function criarAula(aula){
         debugger
         return $http.post(`${url}aula`,aula);
     }

     function atualizarAula(aula){
         return $http.put(`${url}aula/${aula.id}`,aula);        
     }

     function removerAula(aula){
         return $http.delete(`${url}aula/${aula.id}`);
     }

     return {
        listar : getAulas,
        pesquisaId : getAulasPorId,
        atualizar : atualizarAula,
        removerAula : removerAula,
        criar : criarAula
     }
})

modulo.factory('instrutorService',function($http){
    
    let url = 'http://localhost:3000/'

    function getInstrutor(){
        return $http.get(`${url}instrutor`);
    }

    function getIsntrutorPorId(id){
        return $http.get(`${url}instrutor/${id}`);        
    }

    function criarInstrutor(instrutor){
        return $http.post(`${url}instrutor`,instrutor);      
    }

    function atualizarInstrutor(instrutor){
        return $http.put(`${url}instrutor/${instrutor.id}`,instrutor);
    }

    function removerInstrutor(instrutor){
        return $http.delete(`${url}instrutor/${instrutor.id}`)
    }

    return{
        listar : getInstrutor,
        buscarPorId : getIsntrutorPorId,
        criarInstrutor,
        atualizarInstrutor,
        removerInstrutor
    }
})