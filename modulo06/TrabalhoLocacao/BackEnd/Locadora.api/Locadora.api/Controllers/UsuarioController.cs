using Locadora.infraestrutura.Repositorio;
using System;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Locadora.api.Controllers
{
    // Permite usuário não autenticados acessarem a controller
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : BasicaController, IDisposable
    {
        readonly UsuarioRepositorio _usuarioRepositorio;

        public UsuarioController()
        {
            _usuarioRepositorio = new UsuarioRepositorio();
        }

        // Exige que o usuário se autentique
        [BasicAuthorization]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { usuario.Nome, permissao = usuario.Gerente ? "Gerente" : "Usuario"});           
        }        

        protected override void Dispose(bool disposing)
        {

            base.Dispose(disposing);
        }
    }
}