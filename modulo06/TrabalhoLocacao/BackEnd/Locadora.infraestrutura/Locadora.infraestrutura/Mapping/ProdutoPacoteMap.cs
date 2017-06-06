using Locadora.infraestrutura.entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
