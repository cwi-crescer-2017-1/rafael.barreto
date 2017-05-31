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

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro ObterPorIsbn(int isbn)
        {
            var Livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            return Livro;
        }        

        public IEnumerable<Livro> ObterPorGenero(string genero)
        {
            var livro = contexto.Livros.Where(x => x.Genero.Contains(genero));
            return livro;
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
