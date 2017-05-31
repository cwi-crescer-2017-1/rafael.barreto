using EditoraCrescer.Infraesturtura.Respositorios;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{
    public class AutorController : ApiController
    {
        AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }

        public IHttpActionResult Get(int id)
        {
            var autores = repositorio.ObterPorId(id);
            return Ok(autores);
        }

        public IHttpActionResult Put(int id)
        {
            repositorio.remover(id);
            return Ok("removido com sucesso");
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.remover(id);
            return Ok("Removido com sucesso");
        }
    }
}