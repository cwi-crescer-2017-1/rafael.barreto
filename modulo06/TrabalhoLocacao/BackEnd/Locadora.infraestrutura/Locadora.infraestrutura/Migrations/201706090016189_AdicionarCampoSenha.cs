namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarCampoSenha : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Usuario", "Senha", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Usuario", "Senha");
        }
    }
}
