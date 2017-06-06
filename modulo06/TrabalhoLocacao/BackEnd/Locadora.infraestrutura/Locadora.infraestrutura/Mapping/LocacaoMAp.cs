using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            HasRequired(x => x.Cliente);
            //.HasForeignKey(x => x.IdCliente);

            HasRequired(x => x.Produto);
            //.HasForeignKey(x => x.IdProduto);                

            HasRequired(x => x.Pacote);            
            //.HasForeignKey(x => x.IdPacote);
             

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
