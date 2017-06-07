namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarColunaPrecoNaTabelaProduto : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Produto", "preco", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Produto", "preco");
        }
    }
}
