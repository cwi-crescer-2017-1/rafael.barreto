using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    public class ProdutoMap : EntityTypeConfiguration<Produto>
    {
        public ProdutoMap()
        {
            ToTable("Produto");
        }
    }
}
