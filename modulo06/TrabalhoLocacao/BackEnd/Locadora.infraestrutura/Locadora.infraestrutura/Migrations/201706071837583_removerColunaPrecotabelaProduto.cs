namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class removerColunaPrecotabelaProduto : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Produto", "preco");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Produto", "preco", c => c.Double(nullable: false));
        }
    }
}
