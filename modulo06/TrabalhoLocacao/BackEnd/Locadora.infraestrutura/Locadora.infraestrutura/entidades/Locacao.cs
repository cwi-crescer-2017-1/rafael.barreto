using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime DataEntregue { get; set; }
        public int IdCliente { get; set; }
        public Cliente Cliente { get; set; }
        public int IdPacote { get; set; }
        public ProdutoPacote Pacote { get; set; }
        public int IdProduto { get; set; }
        public Produto Produto { get; set; }
        public List<ProdutoAdicional> Adicional { get; set; }
    }
}
