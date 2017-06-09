namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class locacaoTornarDataEntregueParaPoderSerNula : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Locacao", "DataEntregue", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Locacao", "DataEntregue", c => c.DateTime(nullable: false));
        }
    }
}
