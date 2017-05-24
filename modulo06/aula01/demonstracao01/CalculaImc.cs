using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demonstracao01
{
    class CalculaImc

    {
        public double altura { get; set; }
        public double peso { get; set; }
        public CalculaImc(double altura,double peso)
        {
            this.altura = altura;
            this.peso = peso;
        }

        public double calcular()
        {
            return peso / (Math.Pow(altura, 2));
        }

    }
}
