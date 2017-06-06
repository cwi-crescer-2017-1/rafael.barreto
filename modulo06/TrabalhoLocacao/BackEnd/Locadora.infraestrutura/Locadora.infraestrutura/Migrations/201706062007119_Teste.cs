namespace Locadora.infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Teste : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Locacao", name: "IdCliente", newName: "Cliente_Id");
            RenameColumn(table: "dbo.Locacao", name: "IdPacote", newName: "Pacote_Id");
            RenameColumn(table: "dbo.Locacao", name: "IdProduto", newName: "Produto_Id");
            RenameIndex(table: "dbo.Locacao", name: "IX_IdCliente", newName: "IX_Cliente_Id");
            RenameIndex(table: "dbo.Locacao", name: "IX_IdPacote", newName: "IX_Pacote_Id");
            RenameIndex(table: "dbo.Locacao", name: "IX_IdProduto", newName: "IX_Produto_Id");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Locacao", name: "IX_Produto_Id", newName: "IX_IdProduto");
            RenameIndex(table: "dbo.Locacao", name: "IX_Pacote_Id", newName: "IX_IdPacote");
            RenameIndex(table: "dbo.Locacao", name: "IX_Cliente_Id", newName: "IX_IdCliente");
            RenameColumn(table: "dbo.Locacao", name: "Produto_Id", newName: "IdProduto");
            RenameColumn(table: "dbo.Locacao", name: "Pacote_Id", newName: "IdPacote");
            RenameColumn(table: "dbo.Locacao", name: "Cliente_Id", newName: "IdCliente");
        }
    }
}
