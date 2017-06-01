using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Respositorios;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{
    [RoutePrefix("api/Livros")]

    public class LivrosController : ApiController
    {
        private Contexto contexto = new Contexto();

        private LivroRepositorio repositorio = new LivroRepositorio();

        
        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }
        [HttpGet]
        [Route("pagina{pagina:int}")]
        public IHttpActionResult Get(int pagina)
        {
            var livros = repositorio.ObterPorPagina(pagina);
            return Ok(livros);
        }

        [HttpGet]
        [Route("{Isbn:int}")]
        public IHttpActionResult BuscaPorIsbn(int Isbn)
        {
            var livros = repositorio.ObterPorIsbn(Isbn);
            return Ok(livros);
        }

        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);
            return Ok(livros);
        }

        [HttpGet]
        [Route("lancamentos")]       
        public IHttpActionResult lancamentos()
        {
            var livros = repositorio.Lancamentos();
            return Ok(livros);
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Cadastrar(livro);
            return Ok("Cadastrado com Sucesso");       
        }

        [Route("delete/{Isbn:int}")]
        public IHttpActionResult Delete(int Isbn)
        {
            repositorio.Remover(Isbn);
            return Ok("Livro Removido");
        }

        [Route("update/{Isbn:int}")]
        public IHttpActionResult Put(int Isbn, Livro livro)
        {
            var atualizou = repositorio.Atualizar(Isbn, livro);

            if (atualizou) return Ok("Livro atualizado com sucesso");
            else return BadRequest("Erro");
        }
    }
}