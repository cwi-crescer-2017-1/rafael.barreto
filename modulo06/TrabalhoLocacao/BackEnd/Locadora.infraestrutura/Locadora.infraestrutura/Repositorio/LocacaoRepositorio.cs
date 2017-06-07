using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.Repositorio
{   
     public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public void NovaLocacao(Locacao locacao)
        {
            contexto.Locacao.Add(locacao);
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

        public IEnumerable<Produto> listarProduto()
        {
            var produtos = contexto.Produto.ToList();
            return produtos;
        }

        public IEnumerable<ProdutoPacote> listarPacotes()
        {
            var pacotes = contexto.Pacote.ToList();
            return pacotes;
        }

        public void AdicionarLocacao(Locacao novaLocacao)
        {
            contexto.Locacao.Add(novaLocacao);
            contexto.SaveChanges();
        }

        //-------------- pacotes metodo -----------------

        public IEnumerable<ProdutoAdicional> BuscarAdicionais()
        {
            var adicional = contexto.Adicional.ToList();
            return adicional;
        }

    }
}
