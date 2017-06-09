namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarColunaValorTotalNaLocacao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Locacao", "ValotTotal", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Locacao", "ValotTotal");
        }
    }
}
