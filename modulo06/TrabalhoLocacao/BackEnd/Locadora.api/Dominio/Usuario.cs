using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.entidades
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public bool Gerente { get; set; }
    }
}
