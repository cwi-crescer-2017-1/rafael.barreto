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
            QtdHoras = Demonstrativo.truncar(qtdHoras);
            ValorTotalHoras = valorTotalHoras;            
        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
