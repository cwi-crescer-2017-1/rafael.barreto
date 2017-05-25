using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace folhaPagamento.classes
{
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = Math.Round(qtdHoras,2);
            ValorTotalHoras = Math.Round(valorTotalHoras,2);            
        }

        public double CalcularHextra(double salarioBase)
        {               
            return Math.Round((salarioBase / this.ValorTotalHoras) * this.QtdHoras,2);
        }

        public double CalcularHDescontadas(double salarioBase)
        {
            return Math.Round((salarioBase / this.ValorTotalHoras) * this.QtdHoras,2);
        }

        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
