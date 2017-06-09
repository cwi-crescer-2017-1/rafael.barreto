using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.api.Models
{
    public class LocacaoModel
    {
        public DateTime DataEntrega { get; set; }        
        public Cliente Cliente { get; set; }
        public ProdutoPacote Pacote { get; set; }
        public Produto Produto { get; set; }
        public List<ProdutoAdicional> Adicional { get; set; }
    }   
}