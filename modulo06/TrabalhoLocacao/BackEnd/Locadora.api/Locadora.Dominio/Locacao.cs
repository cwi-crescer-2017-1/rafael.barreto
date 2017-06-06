using System;
using System.Collections.Generic;

namespace Locadora.Dominio
{
    public class Locacao
    {
        public int Id { get; set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataEntrega { get; set; }
        public DateTime DataEntregue { get; set; }        
        public Cliente Cliente { get; set; }        
        public ProdutoPacote Pacote { get; set; }       
        public Produto Produto { get; set; }
        public List<ProdutoAdicional> Adicional { get; private set; }

        private Locacao() { }

        public Locacao(Cliente cliente,Produto produto, DateTime dataEntrega,List<ProdutoAdicional> adicional)
        {
            this.DataLocacao = DateTime.UtcNow;
            this.DataEntrega = dataEntrega;
            this.Produto = produto;
            this.Cliente = cliente;
            this.Adicional = adicional;
        }

        public void AdicionarAdicional(ProdutoAdicional adicional)
        {
            this.Adicional.Add(adicional);
        }
    }
}
