using Locadora.api.Models;
using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System.Web.Http;

namespace Locadora.api.Controllers
{
    [RoutePrefix("api/cliente")]
    public class ClienteController : ApiController
    {
        ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet]
        public IHttpActionResult ListarClientes()
        {
            var clientes = repositorio.BuscarCliente();
            return Ok(clientes);
        }

        [HttpPost]
        [Route("cadastrar")]
        public IHttpActionResult CadastrarCliente(ClienteModel model)
        {
            var cliente = new Cliente(model.Nome, model.Cpf, model.Genero, model.DataNascimento, model.Rua, model.Numero, model.Cidade);
            repositorio.AdicionarCliente(cliente);                
            return Ok("cadastrado com sucesso");
        }

    }
}
