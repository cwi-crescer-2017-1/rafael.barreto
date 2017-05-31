using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Respositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public Autor ObterPorId(int id)
        {        
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            return autor;
        }

        public void cadastrar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Atualizar(int id, Autor autor)
        {
            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void remover(int id)
        {
            var autor = ObterPorId(id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
    }
}
