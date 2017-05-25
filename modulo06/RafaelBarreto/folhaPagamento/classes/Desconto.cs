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

        public double CalcularInss()
        {
            if (this.Valor <= 1000) this.Aliquota = 0.08;
            else if (this.Valor <= 1500)this.Aliquota = 0.9;
            else this.Aliquota = 0.10;
            return Math.Round(this.Valor = this.Valor * this.Aliquota,2);
        }
       
        public double CalcularIrrf()
        {
            if (this.Valor <= 1710.78) this.Aliquota = 0;
            else if (this.Valor <= 2563.91) this.Aliquota = 0.075;
            else if (this.Valor <= 3418.59) this.Aliquota = 0.15;
            else if (this.Valor <= 4271.59) this.Aliquota = 0.225;
            else this.Aliquota = 0.275;                           
            return Math.Round(this.Valor * this.Aliquota,2);
        }

        public double CalcularFgts(double Hextras, double Hdescontadas)
        {
            return Math.Round((this.Valor + Hextras - Hdescontadas) * 0.11,2);
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
