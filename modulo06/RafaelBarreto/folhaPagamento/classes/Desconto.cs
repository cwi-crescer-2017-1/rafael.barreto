using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace folhaPagamento.classes
{
    public class Desconto //INSS: Calcule o INSS com base no Total de Proventos e aplique a alíquota conforme as faixas salariais: Até R$1000,00 utilize 8%, até R$1500,00 9% e acima disso 10%.
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }       
       
        public double CalcularFgts(double Hextras, double Hdescontadas)
        {
            return Math.Round((this.Valor + Hextras - Hdescontadas) * 0.11,2);
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
