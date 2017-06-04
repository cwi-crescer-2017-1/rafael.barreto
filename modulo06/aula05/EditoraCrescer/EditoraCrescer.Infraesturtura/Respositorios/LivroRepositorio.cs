using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Respositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<dynamic> Obter()
        {
            var livros = contexto.Livros.Select(x=> 
                    new {Isbn = x.Isbn, Titulo = x.Titulo , Capa = x.Capa, Autor = x.Autor.Nome, Genero = x.Genero})
                    .ToList();
            return livros;
        }

        public int ObterNumeroDeLivros()
        {
            var livros = contexto.Livros.Select(x =>
                    new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, Autor = x.Autor.Nome, Genero = x.Genero })
                    .ToList();
            return livros.Count;
        }

        public IEnumerable<dynamic> ObterPorPagina(int pagina)
        {
            var pular = (pagina * 8)-8;
            var intervalo = pagina * 8;
            var livros = contexto.Livros.Select(x =>
                    new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, Autor = x.Autor.Nome, Genero = x.Genero })
                    .OrderBy(x => x.Titulo)
                    .Skip(pular)
                    .Take(intervalo)
                    .ToList();
            return livros;
        }

        public Livro ObterPorIsbn(int isbn)
        {
            var Livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            return Livro;
        }        

        public IEnumerable<dynamic> ObterPorGenero(string genero)
        {
            var livro = contexto.Livros.Where(x=> x.Genero.Contains(genero))
                    .Select(x => new {Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, Autor = x.Autor.Nome, Genero = x.Genero})
                    .ToList();
            return livro;
        }

        public IEnumerable<dynamic> Lancamentos()
        {
            var dataUmaSemanaAtraz = DateTime.Now.AddDays(-7);
            var livros = contexto.Livros.Where(x => x.DataPublicacao >= dataUmaSemanaAtraz)
                    .Select(x => new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, Autor = x.Autor.Nome, Genero = x.Genero })
                    .ToList();
            return livros;
        }

        public void Cadastrar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public bool Atualizar(int Isbn, Livro livro)
        {
            if (Isbn != livro.Isbn)
                return false;
            
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
            return true;           
        }

        public void Remover(int Isbn)
        {
            var livro = ObterPorIsbn(Isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }
    }
}
