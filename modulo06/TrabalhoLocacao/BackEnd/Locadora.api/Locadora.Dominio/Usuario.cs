﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public bool Gerente { get; set; }

        private Usuario() { }

        public Usuario(string nome , bool gerente)
        {
            this.Nome = nome;
            this.Gerente = gerente;
        }
    }
}
