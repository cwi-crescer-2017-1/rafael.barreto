using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace folhaPagamento.classes
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {

            var HorasExtrasDemonstrativo = horasExtras * (salarioBase / horasCategoria);
            var HorasDescontadasDemonstrativo = horasDescontadas * (salarioBase/horasCategoria);
            var HorasExtras = new HorasCalculadas(horasExtras, HorasExtrasDemonstrativo);
            var HorasDescontadas = new HorasCalculadas(horasDescontadas, HorasDescontadasDemonstrativo);
            var TotalProventos = (salarioBase + HorasExtrasDemonstrativo) - HorasDescontadasDemonstrativo;
            var aliquota = calcularAliquotaInss(TotalProventos);
            var valorInss = TotalProventos * aliquota;
            var Inss = new Desconto(aliquota, valorInss);
            aliquota = calcularAliquotaIrrf(TotalProventos);
            var valorIrrf = TotalProventos * aliquota;
            var Irrf = new Desconto(aliquota, valorIrrf);
            var TotalDescontos = valorInss + valorIrrf;
            var TotalLiquido = TotalProventos - TotalDescontos;
            var valorFgts = TotalProventos * 0.11;
            var Fgts = new Desconto(0.11, valorFgts);

            return new Demonstrativo(
                            salarioBase,
                            horasCategoria, 
                            HorasExtras, 
                            HorasDescontadas, 
                            TotalProventos, 
                            Inss, 
                            Irrf,
                            TotalDescontos,
                            TotalLiquido,
                            Fgts
                       );
        }

        public double CalcularHoras(double qtdHoras, double valorHora)
        {            
            return (valorHora*qtdHoras);
        }

        public double CalcularImposto(double valor, double aliquota)
        {            
            return Demonstrativo.truncar(valor*aliquota);
        }

        public double calcularAliquotaInss(double valor)
        {
            double aliquota = 0;
            if (valor <= 1000) aliquota = 0.08;
            else if (valor <= 1500) aliquota = 0.09;
            else aliquota= 0.10;
            return aliquota;
        }

        public double calcularAliquotaIrrf(double valor)
        {
            double Aliquota = 0;

            if (valor <= 1710.78) Aliquota = 0;
            else if (valor <= 2563.91) Aliquota = 0.075;
            else if (valor <= 3418.59) Aliquota = 0.15;
            else if (valor <= 4271.59) Aliquota = 0.225;
            else Aliquota = 0.275;
            return Aliquota;            
        }
    }

}
