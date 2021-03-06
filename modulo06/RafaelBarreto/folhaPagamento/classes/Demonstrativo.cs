﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace folhaPagamento.classes
{
    public class Demonstrativo
    {
        public Demonstrativo() { }

        public Demonstrativo(
            double salarioBase,//ok
            double hrsConvencao,//ok
            HorasCalculadas horasExtras,//ok
            HorasCalculadas horasDescontadas,//ok
            double totalProventos,//ok
            Desconto inss,//ok
            Desconto irrf,//ok
            double totalDescontos,//ok
            double totalLiquido,//ok
            Desconto fgts)// construtor
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }        

        internal static double truncar(double valor)
        {
            valor = valor * 100;
            valor = Math.Truncate(valor);
            valor = valor / 100;
            return valor;
        }

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }   
}
