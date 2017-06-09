using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }
        public string Rua { get; set; }
        public int Numero { get; set; }
        public string Cidade { get; set; }

        private Cliente() { }

        public Cliente(string nome,string cpf, Genero genero,DateTime dataNascimento,string rua, int numero, string cidade)
        {
            this.Nome = nome;
            this.Cpf = cpf;
            this.Genero = genero;
            this.DataNascimento = dataNascimento;
            this.Rua = rua;
            this.Numero = numero;
            this.Cidade = cidade;
        }       
    }
}
