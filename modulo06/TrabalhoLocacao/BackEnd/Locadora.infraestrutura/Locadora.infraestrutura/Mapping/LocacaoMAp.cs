using Locadora.infraestrutura.entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.Mapping
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);

            HasRequired(x => x.Produto)
                .WithMany()
                .HasForeignKey(x => x.IdProduto);

            HasRequired(x => x.Pacote)
                .WithMany()
                .HasForeignKey(x => x.IdPacote);

            ToTable("Locacao");
            HasMany(x => x.Adicional)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdLocacao");
                    x.MapRightKey("IdAdicional");
                    x.ToTable("LocacaoAdicionais");
                });
        }
    }
}
