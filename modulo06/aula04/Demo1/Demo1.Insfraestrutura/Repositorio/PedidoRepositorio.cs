using System.Collections.Generic;
using Demo1.Dominio.entidades;
using System.Data.SqlClient;

namespace Demo1.Insfraestrutura.Repositorio
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
                   @"Server=13.65.101.67;
                  User id=rafael.barreto;
                  Password=123456;
                  Database=aluno13db";


        public void Alterar(Pedido pedido)
        {
           
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                //inserir ped.

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO Pedido(NomeCliente)
                                            VALUES (@nomeCliente)";
                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "select @@IDENTITY";
                    var resultado = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)resultado;
                }

                foreach (var item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"INSERT INTO itemPedido(pedidoId,produtoId,quantidade)
                                                   VALUES(@pedidoId,@produtoId,@quantidade)";

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId",item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                }

                conexao.Close();
            }
        }

        public void Excluir(int id)
        {
           
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT NomeCliente, Id FROM Pedido";
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = new List<ItemPedido>();

                        foreach (var item in pedido.Itens)
                        {
                            item.Id = (int)dataReader["Id"];
                            item.Quantidade = (int)dataReader["Quantidades"];
                            item.ProdutoId = (int)dataReader["PodudoId"];
                            pedido.Itens.Add(item);
                        }
                        pedido.Id = (int)dataReader["Id"];
                        pedidos.Add(pedido);
                    }

                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            var pedido = new Pedido();

            using (var conexao = new SqlConnection(stringConexao))
            {                
                conexao.Open();
                
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id,NomeCliente
                                            FROM Pedido
                                            WHERE Id = @Id";

                    comando.Parameters.AddWithValue("@Id", id);                       

                    comando.ExecuteNonQuery();

                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];                                              
                    }
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id,produtoId,quantidade
                                            FROM itemPedido
                                            WHERE PedidoId = @pedidoId";
                                       
                    comando.Parameters.AddWithValue("@pedidoId", pedido.Id);

                    foreach (var item in pedido.Itens)
                    {
                        pedido.Itens.Add(item);
                    }
                }
            }
            return pedido;
        }
     }
}

