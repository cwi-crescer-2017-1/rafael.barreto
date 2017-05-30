namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Autor",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Livros",
                c => new
                    {
                        Isbn = c.Int(nullable: false, identity: true),
                        Titulo = c.String(),
                        Descricao = c.String(),
                        Genero = c.String(),
                        DataPublicacao = c.DateTime(nullable: false),
                        IdAutor = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Isbn)
                .ForeignKey("dbo.Autor", t => t.IdAutor, cascadeDelete: true)
                .Index(t => t.IdAutor);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autor");
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            DropTable("dbo.Livros");
            DropTable("dbo.Autor");
        }
    }
}
