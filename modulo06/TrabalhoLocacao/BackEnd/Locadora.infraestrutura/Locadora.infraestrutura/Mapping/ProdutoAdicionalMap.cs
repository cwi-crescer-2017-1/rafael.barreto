﻿using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.infraestrutura.Mapping
{
    class ProdutoAdicionalMap : EntityTypeConfiguration<ProdutoAdicional>
    {
        public ProdutoAdicionalMap()
        {
            ToTable("Adicional");
        }
    }
}
