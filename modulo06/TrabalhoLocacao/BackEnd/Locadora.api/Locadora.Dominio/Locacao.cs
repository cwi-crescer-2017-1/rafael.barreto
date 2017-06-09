using System;
using System.Collections.Generic;

namespace Locadora.Dominio
{
    public class Locacao
    {
        public int Id { get; set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataEntrega { get; set; }
        public DateTime? DataEntregue { get; set; }        
        public Cliente Cliente { get; set; }        
        public ProdutoPacote Pacote { get; set; }
        public double ValotTotal { get; set; }
        public Produto Produto { get; set; }
        public List<ProdutoAdicional> Adicional { get; private set; }

        private Locacao() { }

        public Locacao(Cliente cliente,ProdutoPacote pacote,Produto produto, DateTime dataEntrega,List<ProdutoAdicional> adicional)
        {
            this.DataLocacao = DateTime.UtcNow;
            this.DataEntrega = dataEntrega;
            this.Produto = produto;
            this.Cliente = cliente;
            this.Adicional = adicional;
            this.Pacote = pacote;
            CalcularTotal();
        }

        public void AdicionarAdicional(ProdutoAdicional adicional)
        {
            this.Adicional.Add(adicional);
        }

        public void CalcularTotal()
        {
            if (this.Adicional == null)
                this.ValotTotal += Pacote.Preco;
            else
            {
                foreach (var p in this.Adicional)
                {
                    this.ValotTotal += p.Preco;
                }
            }
            this.ValotTotal += this.Pacote.Preco;
        }
    }
}
