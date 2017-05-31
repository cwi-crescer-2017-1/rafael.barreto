namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarCapaNoLivro : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "Capa", c => c.String());
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Livros", "DataRevisao");
            DropColumn("dbo.Livros", "Capa");
        }
    }
}
