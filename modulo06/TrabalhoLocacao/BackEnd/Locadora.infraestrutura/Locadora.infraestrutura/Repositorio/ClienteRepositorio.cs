using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.Repositorio
{
    public class ClienteRepositorio
    {
        private Contexto contexto = new Contexto();

        public void AdicionarCliente(Cliente cliente)
        {
            contexto.Cliente.Add(cliente);
            contexto.SaveChanges();            
        }

        public IEnumerable<Cliente> BuscarCliente()
        {
            var listaCliente = contexto.Cliente.ToList();
            return listaCliente;
        }
        
    }
}
