using Locadora.api.Models;
using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System;
using System.Web.Http;

namespace Locadora.api.Controllers
{
    [RoutePrefix("api/locacoes")]
    [BasicAuthorization]
    public class LocacaoController : ApiController
    {
        LocacaoRepositorio repositorio = new LocacaoRepositorio();

        [HttpGet]
        [Route("listarlocacoes")]
        public IHttpActionResult listarLocacoes()
        {
            var locacoes = repositorio.ObterLocacoes();
            return Ok(new { dados = locacoes });
        }

        //[HttpGet]
        //[Route("relatorios/{data:datetime}")]
        //public IHttpActionResult listarLocacoesPorData(DateTime data)
        //{
        //    repositorio.ObterLocacoesPorData(data);
        //}

        [HttpGet]
        [Route("adicionais")]
        public IHttpActionResult ListarAdicionais()
        {
            var Adicionais = repositorio.BuscarAdicionais();
            return Ok(new { dados = Adicionais });
        }
        
        [HttpGet]
        [Route("produtos")]
        public IHttpActionResult ListarProduto()
        {
            var produto = repositorio.ListarProduto();
            return Ok(new { dados = produto});
        }

        [HttpGet]
        [Route("pacotes")]
        public IHttpActionResult listarPacotes()
        {
            var pacotes = repositorio.ListarPacotes();
            return Ok(new { dados = pacotes });
        }

        [HttpPost]
        [Route("cadastrar")]
        public IHttpActionResult CadastrarLocacao(LocacaoModel model)   
        {
            var novaLocacao = new Locacao(model.Cliente ,model.Pacote,model.Produto, model.DataEntrega, model.Adicional);
            repositorio.NovaLocacao(novaLocacao);
            return Ok(new { mensagem = "Cadastrado com Sucesso" });
        }
    }
}
