using Demo1.Dominio.entidades;
using Demo1.Insfraestrutura.Repositorio;
using System.Web.Http;
using System.Web.Mvc;

namespace Demo1.WebApi.Controllers
{
    public class PedidoController : ApiController
    {

        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Post(Pedido pedido)
        {

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Get()
        {
            var pedidos = _pedidoRepositorio.Listar();
            return Ok(pedidos);
        }

        public IHttpActionResult Get(int id)
        {
            
            return null;
        }
    }
}