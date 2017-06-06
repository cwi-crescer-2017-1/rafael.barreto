using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.infraestrutura.Repositorio
{   
    class LocacaoRepositorio
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



    }
}
