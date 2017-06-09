using Locadora.api.Models;
using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System;
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
        [Route("relatorios/{data:datetime}")]
        [BasicAuthorization(Roles = "Gerente")]
        public IHttpActionResult listarLocacoesPorData(DateTime data)
        {
            var locacoes = repositorio.ObterLocacoesPorData(data);
            return Ok(new {dados = locacoes });
        }

        [HttpGet]
        [Route("relatorios/naoentregue")]        
        public IHttpActionResult listarLocacoesNaoEntregue()
        {
            var locacoes = repositorio.naoEntregue();
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

        [HttpPut]
        [Route("devolucao/{id}")]
        public IHttpActionResult devolver(int id)
        {
            var locacao = repositorio.ObterLocacaoPorId(id);
            if (locacao == null)
                return BadRequest("erro");
            else
            {
                locacao.DevolverLocacao();
                repositorio.DevolverPedido(locacao);
                return Ok(new { mensagem = "devolvido com sucesso" });
            }
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
