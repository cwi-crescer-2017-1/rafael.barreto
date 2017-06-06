using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        private Produto() { }

        public Produto(string nome)
        {
            this.Nome = nome;
        }
    }
}
