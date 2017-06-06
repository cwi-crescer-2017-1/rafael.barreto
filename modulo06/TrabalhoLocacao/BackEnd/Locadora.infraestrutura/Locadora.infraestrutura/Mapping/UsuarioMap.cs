using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
        }
    }
}
