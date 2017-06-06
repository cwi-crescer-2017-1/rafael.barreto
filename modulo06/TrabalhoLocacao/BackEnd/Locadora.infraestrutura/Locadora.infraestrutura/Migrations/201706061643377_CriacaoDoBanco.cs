namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Adicional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Preco = c.Double(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Cpf = c.String(),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                        Rua = c.String(),
                        Numero = c.Int(nullable: false),
                        Cidade = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataLocacao = c.DateTime(nullable: false),
                        DataEntrega = c.DateTime(nullable: false),
                        DataEntregue = c.DateTime(nullable: false),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descricao = c.String(),
                        Preco = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoAdicionais",
                c => new
                    {
                        IdLocacao = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdLocacao, t.IdAdicional })
                .ForeignKey("dbo.Locacao", t => t.IdLocacao, cascadeDelete: true)
                .ForeignKey("dbo.Adicional", t => t.IdAdicional, cascadeDelete: true)
                .Index(t => t.IdLocacao)
                .Index(t => t.IdAdicional);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.LocacaoAdicionais", "IdAdicional", "dbo.Adicional");
            DropForeignKey("dbo.LocacaoAdicionais", "IdLocacao", "dbo.Locacao");
            DropIndex("dbo.LocacaoAdicionais", new[] { "IdAdicional" });
            DropIndex("dbo.LocacaoAdicionais", new[] { "IdLocacao" });
            DropIndex("dbo.Locacao", new[] { "IdProduto" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.LocacaoAdicionais");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Locacao");
            DropTable("dbo.Cliente");
            DropTable("dbo.Adicional");
        }
    }
}
