using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
        }        
    }
}
