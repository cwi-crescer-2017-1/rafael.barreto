namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ArrumarTabelaRevisores : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Revisors", newName: "Revisor");
            DropForeignKey("dbo.Livros", "Revisor_Id", "dbo.Revisors");
            DropIndex("dbo.Livros", new[] { "Revisor_Id" });
            DropColumn("dbo.Livros", "IdRevisor");
            RenameColumn(table: "dbo.Livros", name: "Revisor_Id", newName: "IdRevisor");
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisor", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisor");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int());
            RenameColumn(table: "dbo.Livros", name: "IdRevisor", newName: "Revisor_Id");
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "Revisor_Id");
            AddForeignKey("dbo.Livros", "Revisor_Id", "dbo.Revisors", "Id");
            RenameTable(name: "dbo.Revisor", newName: "Revisors");
        }
    }
}
