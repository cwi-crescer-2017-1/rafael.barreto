﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class ProdutoAdicional
    {
        public int Id {get; set;}
        public string Nome {get; set;}
        public double Preco {get; set;}
        public int Quantidade {get; set;}

        private ProdutoAdicional() { }

        public ProdutoAdicional(string nome, double preco, int quantidade)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Quantidade = quantidade;
        }
    }
}
