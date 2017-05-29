using Demo1.Insfraestrutura.Repositorio;
using Demo1.WebApi.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class Produtoscontroller : ApiController
    {
        ProdutoRepositorio _produtoRepositorio = new ProdutoRepositorio();

        public IHttpActionResult Post(Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _produtoRepositorio.Criar(produto);

            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            var produtos = _produtoRepositorio.Listar();

            return Ok(produtos);
        }
    }
}