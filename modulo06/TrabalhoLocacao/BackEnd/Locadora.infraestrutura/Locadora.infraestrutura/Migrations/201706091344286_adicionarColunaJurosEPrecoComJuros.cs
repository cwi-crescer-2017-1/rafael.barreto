namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarColunaJurosEPrecoComJuros : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Locacao", "Juros", c => c.Double(nullable: false));
            AddColumn("dbo.Locacao", "ValorComJuros", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Locacao", "ValorComJuros");
            DropColumn("dbo.Locacao", "Juros");
        }
    }
}
