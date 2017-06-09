namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class arrumandoNomeDaColunaValorTotal : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Locacao", "ValorTotal", c => c.Double(nullable: false));
            DropColumn("dbo.Locacao", "ValotTotal");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Locacao", "ValotTotal", c => c.Double(nullable: false));
            DropColumn("dbo.Locacao", "ValorTotal");
        }
    }
}
