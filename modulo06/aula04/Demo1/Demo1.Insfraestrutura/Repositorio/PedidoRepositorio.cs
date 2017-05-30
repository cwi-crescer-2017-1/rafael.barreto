using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.entidades;
using System.Data.SqlClient;

namespace Demo1.Insfraestrutura.Repositorio
{
    class PedidoRepositorio : IPedidoRepositorio
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

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO Pedido(NomeCliente)
                                            VALUES(@NomeCliente)";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "select @@IDENTITY";
                    var resultado = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)resultado;
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
                    comando.CommandText =
                        "SELECT Id, NomeCliente FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];                      

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

                        comando.Parameters.AddWithValue("@Id",id);

                        var dataReader = comando.ExecuteReader();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                }
            }
            return pedido;
        }
     }
}

