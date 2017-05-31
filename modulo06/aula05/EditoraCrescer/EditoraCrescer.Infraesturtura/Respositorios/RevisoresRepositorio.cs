using EditoraCrescer.Infraesturtura.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraesturtura.Respositorios
{
    public class RevisoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterPorId(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            return revisor;
        }

        public void cadastrar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Atualizar(int id, Revisor revisor)
        {
            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void remover(int id)
        {
            var revisor = ObterPorId(id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}
