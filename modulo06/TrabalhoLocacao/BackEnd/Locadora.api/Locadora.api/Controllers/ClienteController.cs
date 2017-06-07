using Locadora.api.Models;
using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System.Web.Http;

namespace Locadora.api.Controllers
{
    [RoutePrefix("api/clientes")]
    public class ClienteController : ApiController
    {
        ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet]
        [Route("listar")]
        public IHttpActionResult ListarClientes()
        {
            var clientes = repositorio.BuscarCliente();
            return Ok(new { dados = clientes });
        }

        [HttpPost]
        [Route("cadastrar")]
        public IHttpActionResult CadastrarCliente(ClienteModel model)
        {
            var cliente = new Cliente(model.Nome, model.Cpf, model.Genero, model.DataNascimento, model.Rua, model.Numero, model.Cidade);
            repositorio.AdicionarCliente(cliente);                
            return Ok(new { mensagem = "cadastrado com sucesso" });
        }
    }
}
