using ChatAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatAPI.Controllers
{
    public class LoginController : ApiController
    {
        private static int Id = 1;
        private static List<Usuario> listaUsuarios = new List<Usuario>();

        public IEnumerable<Usuario> Get(int Id)
        {
            return listaUsuarios;
        }

        public IHttpActionResult Post(string nome)
        {
            Usuario usuario = new Usuario();
            usuario.Nome = nome;
            listaUsuarios.Add(usuario);
            usuario.Id = Id++;

            return Ok("usuario cadastrado com sucesso");
        }
    }
}
