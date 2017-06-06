using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    public class ProdutoPacoteMap : EntityTypeConfiguration<ProdutoPacote>
    {
        public ProdutoPacoteMap()
        {
            ToTable("Pacote");
        }
    }
}
