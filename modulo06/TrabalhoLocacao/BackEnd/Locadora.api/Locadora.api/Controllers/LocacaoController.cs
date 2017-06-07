using Locadora.api.Models;
using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System.Web.Http;

namespace Locadora.api.Controllers
{
    [RoutePrefix("api/locacoes")]
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
            var produto = repositorio.listarProduto();
            return Ok(new { dados = produto});
        }

        [HttpGet]
        [Route("pacotes")]
        public IHttpActionResult listarPacotes()
        {
            var pacotes = repositorio.listarPacotes();
            return Ok(new { dados = pacotes });
        }

        [HttpPost]
        [Route("cadastrar")]
        public IHttpActionResult CadastrarLocacao(LocacaoModel model)
        {
            var novaLocacao = new Locacao(model.Cliente, model.Produto, model.DataEntrega, model.Adicional);
            repositorio.AdicionarLocacao(novaLocacao);
            return Ok(new { mensagem = "Cadastrado com Sucesso" });
        }
    }
}
