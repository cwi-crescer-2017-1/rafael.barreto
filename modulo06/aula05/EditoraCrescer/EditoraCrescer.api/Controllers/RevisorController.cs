using EditoraCrescer.Infraesturtura.Respositorios;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{

    public class RevisorController : ApiController
    {
        RevisoresRepositorio repositorio = new RevisoresRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();
            return Ok(revisores);
        }

        public IHttpActionResult Get(int id)
        {
            var revisores = repositorio.ObterPorId(id);
            return Ok(revisores);
        }


        [Route("adicionar/{id:int}")]
        public IHttpActionResult Put(int id)
        {
            repositorio.remover(id);
            return Ok("removido com sucesso");
        }

        [Route("remover/{id:int}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.remover(id);
            return Ok("Removido com sucesso");
        }
    }
}
