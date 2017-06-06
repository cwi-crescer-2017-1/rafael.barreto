using Locadora.Dominio;
using Locadora.infraestrutura.Mapping;
using System.Data.Entity;

namespace Locadora.infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ConectionString") { }

        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Locacao> Locacao { get; set; }
        public DbSet<Produto> Produto { get; set; }
        public DbSet<ProdutoAdicional> Adicional { get; set; }
        public DbSet<ProdutoPacote> Pacote { get; set; }
        public DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new ProdutoAdicionalMap());
            modelBuilder.Configurations.Add(new ProdutoPacoteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }
    }
}
