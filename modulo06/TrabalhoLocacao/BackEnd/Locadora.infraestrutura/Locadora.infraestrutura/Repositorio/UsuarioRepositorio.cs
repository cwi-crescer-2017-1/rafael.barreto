using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.Repositorio
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public Usuario Obter(string nome)
        {
            return contexto.Usuario.Where(u => u.Nome == nome).FirstOrDefault();
        }
    }
}
