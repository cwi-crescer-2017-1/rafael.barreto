using Locadora.Dominio;
using System.Collections.Generic;
using System.Linq;
using System;

namespace Locadora.infraestrutura.Repositorio
{
    public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public void NovaLocacao(Locacao locacao)
        {
            foreach (var adicional in locacao.Adicional)
            {
                contexto.Entry(adicional).State = System.Data.Entity.EntityState.Unchanged;
            }
            contexto.Entry(locacao.Pacote).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.Produto).State = System.Data.Entity.EntityState.Unchanged;           
            contexto.Entry(locacao.Cliente).State = System.Data.Entity.EntityState.Unchanged;            
            contexto.Locacao.Add(locacao);
            contexto.SaveChanges();            
        }

        public IEnumerable<dynamic> ObterLocacoesPorData(DateTime data)
        {
            var dataCalculo = data.AddDays(-30);
            return contexto.Locacao
                    .Where(c => c.DataLocacao >= dataCalculo && c.DataLocacao < data && c.DataEntregue != null)
                    .Select(x => new
                        {
                            id = x.Id,
                            nome = x.Cliente.Nome,
                            pacote = x.Pacote.Nome,
                            cidade = x.Cliente.Cidade,
                            rua = x.Cliente.Rua,
                            numero = x.Cliente.Numero,
                            dataLocacao = x.DataLocacao,
                            dataEntrega = x.DataEntrega,
                            dataEtregue = x.DataEntregue,
                            juros = x.Juros,
                            valorTotal = x.ValorComJuros,
                            preco = x.ValorTotal
                        }).ToList();
        }

        public object naoEntregue()
        {
            return contexto.Locacao
                    .Where(c => c.DataEntregue == null)
                    .Select(x => new
                    {
                        id = x.Id,
                        nome = x.Cliente.Nome,
                        pacote = x.Pacote.Nome,
                        cidade = x.Cliente.Cidade,
                        rua = x.Cliente.Rua,
                        numero = x.Cliente.Numero,
                        dataLocacao = x.DataLocacao,
                        dataEntrega = x.DataEntrega,
                        dataEtregue = x.DataEntregue,
                        juros = x.Juros,
                        valorTotal = x.ValorComJuros,
                        preco = x.ValorTotal
                    }).ToList();

        }

        public void DevolverPedido(Locacao locacao)
        {
            contexto.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public IEnumerable<dynamic> ObterLocacoes()
        {
            var locacao = contexto.Locacao.Select(x => new
                {
                    nome = x.Cliente.Nome,
                    cidade = x.Cliente.Cidade,
                    rua = x.Cliente.Rua,
                    numero = x.Cliente.Numero,
                    dataLocacao = x.DataLocacao,
                    dataEntrega = x.DataEntrega,
                    dataEtregue = x.DataEntregue,
                }
            ).ToList();
            return locacao;
        }

        public void DevolverAdicionais(Locacao locacao)
        {
            foreach(var l in locacao.Adicional)
            {
                foreach(var c in contexto.Adicional)
                {
                   if(c.Id == l.Id)
                    {
                        c.Quantidade += l.Quantidade;
                    }
                }
            }
        }

        public Locacao ObterLocacaoPorId(int id)
        {
            var locacao =  contexto.Locacao.Where(l => l.Id == id).FirstOrDefault();
            return locacao;
        }

        //-------------- pacotes metodo -----------------

        public IEnumerable<ProdutoAdicional> BuscarAdicionais()
        {
            var adicional = contexto.Adicional.ToList();
            return adicional;
        }


        #region metodos cliente
        public Cliente BuscarClientePorId(int id)
        {
            return contexto.Cliente.Where(c => c.Id == id).FirstOrDefault();
        }

        #endregion

        #region Métodos Produto

        public IEnumerable<Produto> ListarProduto()
        {
            var produtos = contexto.Produto.ToList();
            return produtos;
        }

        public IEnumerable<ProdutoPacote> ListarPacotes()
        {
            var pacotes = contexto.Pacote.ToList();
            return pacotes;
        }

        public Produto BuscarProdutoPorId(int id)
        {
            return contexto.Produto.Where(p => p.Id == id).FirstOrDefault();
        }

        public ProdutoPacote BuscarPacotePorId(int id)
        {
            return contexto.Pacote.Where(p => p.Id == id).FirstOrDefault();
        }

        public IEnumerable<ProdutoAdicional> BuscarAdicionalPorId(int id)
        {
            return contexto.Adicional.Where(a => a.Id == id).ToList();
        }

        #endregion
    }
}
