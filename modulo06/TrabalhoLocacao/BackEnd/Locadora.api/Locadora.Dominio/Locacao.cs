using System;
using System.Collections.Generic;
using System.Linq;

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
        public double ValorTotal { get; set; }
        public double Juros { get; set; }
        public double ValorComJuros { get; set; }
        public Produto Produto { get; set; }
        public List<ProdutoAdicional> Adicional { get; set; }

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
            var numeroDiasLocados = Convert.ToInt32(this.DataEntrega.Subtract(this.DataLocacao).TotalDays);
            if (this.Adicional == null)
                this.ValorTotal += Pacote.Preco;
            else
            {
                foreach (var p in this.Adicional)
                {
                    this.ValorTotal += p.Preco;
                }
            }
            this.ValorTotal = (this.ValorTotal + this.Pacote.Preco)* numeroDiasLocados;
        }

        public void DevolverLocacao()
        {
            this.DataEntregue = DateTime.Now;
           // CalcularValoTotalComJuros();
        }

        private void CalcularValoTotalComJuros()
        {
            var numeroDeDiasAtraso = Convert.ToInt32(this.DataEntregue.Value.Subtract(this.DataEntrega).TotalDays);
            var numeroDiasLocados = Convert.ToInt32(this.DataEntrega.Subtract(this.DataLocacao).TotalDays);
            this.Juros = this.Adicional.Sum(a => a.Preco)*numeroDeDiasAtraso;
            this.ValorComJuros = this.ValorTotal + this.Juros;
        }
    }
}
