using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class ProdutoPacote
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Descricao { get; set; }
        public double Preco { get; set; }

        private ProdutoPacote() { }

        public ProdutoPacote(string nome, string descricao, double preco)
        {
            this.Nome = nome;
            this.Descricao = descricao;
            this.Preco = preco;
        }
    }
}
