/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jean.loose
 */
public class Conversor {

    public static void main(String[] args) {

        String binario; 
      	int decimal=0;
      	String octal;
      	String hexadecimal; 
      	int valor=0;
      	int resp=0; 
        String respS;
        Scanner leitor = new Scanner(System.in); 
        
        System.out.println("1 para Decimal\n 2 para Binario\n 3 para Hexadecimal\n 4 para Octal");
        	valor = leitor.nextInt();
        	if (valor == 1)
			{
                                System.out.println("Digite o valor Decimal");
				decimal = leitor.nextInt();
				respS= converteDecimalParaBinario(decimal); 
				System.out.println("valor em Binario: "+respS);
                                respS= converteDecimalParaHexadecimal(decimal);
				System.out.println("valor em Hexadecimal: "+respS);
				respS= converteDecimalParaOctal(decimal);
				System.out.println("valor em Octal: "+respS);
				
			}
			else if (valor == 2)
			{
				System.out.println("Digite o valor Binario");
				binario = leitor.next();	
				resp= converteBinarioParaDecimal(binario);
				System.out.println("valor em Decimal: "+resp); 	
				respS= converteBinarioParaHexadecimal(binario);
				System.out.println("valor em Hexadecimal: "+respS); 	
				respS= converteBinarioParaOctal(binario);
				System.out.println("valor em Octal: "+respS); 
			}
			else if (valor == 3)
			{
				System.out.println("Digite o valor Hexadecimal");
				hexadecimal = leitor.next();
				resp= converteHexadecimalParaDecimal(hexadecimal);
				System.out.println("valor em Decimal: "+resp);
				respS= converteHexadecimalParaOctal(hexadecimal);
				System.out.println("valor em Octal: "+respS);
				respS= converteHexadecimalParaBinario(hexadecimal);
				System.out.println("valor em Binario: "+respS);
			}
			else if (valor == 4)
			{
				System.out.println("Digite o valor Octal");
				octal = leitor.next();
				respS= converteOctalParaBinario(octal);
				System.out.println("valor em Binario: "+respS); 
				resp= converteOctalParaDecimal(octal);
				System.out.println("valor em Decimal: "+resp);
				respS= converteOctalParaHexadecimal(octal);
				System.out.println("valor em Hexadecimal: "+respS);			 
			}
                
    }
    public static int converteBinarioParaDecimal(String valorBinario) {
   int valor = 0;
 

   for (int i=valorBinario.length(); i>0; i--) {
      valor += Integer.parseInt(valorBinario.charAt(i-1)+"")*Math.pow(2, (valorBinario.length()-i));
   }
 
   return valor;
}
    public static String converteBinarioParaHexadecimal(String binario) {
   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   StringBuilder sb = new StringBuilder();
   int posicaoInicial = 0;
   int posicaoFinal = 0;
   char caractereEncontrado = '-';
 

   posicaoInicial = binario.length();
   posicaoFinal = posicaoInicial;
 
   while (posicaoInicial > 0) {
      posicaoInicial = ((posicaoInicial - 4) >= 0) ? posicaoInicial - 4 : 0;
      caractereEncontrado = hexa[converteBinarioParaDecimal(binario.substring(posicaoInicial, posicaoFinal))];
      sb.insert(0, caractereEncontrado);
      posicaoFinal = posicaoInicial;
   }
 
   return sb.toString();
}
    public static String converteBinarioParaOctal(String binario) {
   StringBuilder sb = new StringBuilder();
   int posicaoInicial = 0;
   int posicaoFinal = 0;

   posicaoInicial = binario.length();
   posicaoFinal = posicaoInicial;
 
   while (posicaoInicial > 0) {
      posicaoInicial = ((posicaoInicial - 3) >= 0) ? posicaoInicial - 3 : 0;
      sb.insert(0, converteBinarioParaDecimal(binario.substring(posicaoInicial, posicaoFinal)));
      posicaoFinal = posicaoInicial;
   }
 
   return sb.toString();
}
    public static String converteDecimalParaBinario(int valor) {
   int resto = -1;
   StringBuilder sb = new StringBuilder();
 
   if (valor == 0) {
      return "0";
   }

   while (valor > 0) {
      resto = valor % 2;
      valor = valor / 2;
      sb.insert(0, resto);
   }
 
   return sb.toString();
}
    public static String converteDecimalParaHexadecimal(int valor) {
   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   int resto = -1;
   StringBuilder sb = new StringBuilder();
 
   if (valor == 0) {
      return "0";
   }
 
   while (valor > 0) {
      resto = valor % 16;
      valor = valor / 16;
      sb.insert(0, hexa[resto]);
   }
 
   return sb.toString();
}
    public static String converteDecimalParaOctal(int valor) {
   int resto = -1;
   StringBuilder sb = new StringBuilder();
 
   if (valor == 0) {
      return "0";
   }

   while (valor > 0) {
      resto = valor % 8;
      valor = valor / 8;
      sb.insert(0, resto);
   }
 
   return sb.toString();
}
    public static String converteHexadecimalParaBinario(String valorHexa) {
   int posicao = 0;
   int posicaoArrayHexa = -1;
   StringBuilder sb = new StringBuilder();
   String valorConvertidoParaBinario = null;
   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
 
   while (posicao < valorHexa.length()) {
      posicaoArrayHexa = Arrays.binarySearch(hexa, valorHexa.charAt(posicao));
      valorConvertidoParaBinario = converteDecimalParaBinario(posicaoArrayHexa);
      if (valorConvertidoParaBinario.length() != 4 && posicao > 0) {
         for (int i=0; i < (4-valorConvertidoParaBinario.length()); i++) {
            sb.append("0");
         }
      }
 
      sb.append(valorConvertidoParaBinario);
      posicao++;
   }
   return sb.toString();
}
    public static int converteHexadecimalParaDecimal(String valorHexa) {
   int valor = 0;
   int posicaoCaractere = -1;
   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

   for (int i=valorHexa.length(); i>0; i--) {
      posicaoCaractere = Arrays.binarySearch(hexa, valorHexa.charAt(i-1));
      valor += posicaoCaractere*Math.pow(16, (valorHexa.length()-i));
   }
 
   return valor;
}
    public static String converteHexadecimalParaOctal(String valorHexa) {
   int valorDecimal = converteHexadecimalParaDecimal(valorHexa);
 
   return converteDecimalParaOctal(valorDecimal);
}
    public static String converteOctalParaBinario(String valorOctal) {
   int posicao = 0;
   StringBuilder sb = new StringBuilder();
   String valorConvertidoParaBinario = null;
 
   while (posicao < valorOctal.length()) { 
      valorConvertidoParaBinario = converteDecimalParaBinario(Integer.parseInt(valorOctal.charAt(posicao)+""));                        
          
      if (valorConvertidoParaBinario.length() != 3  && posicao > 0) {
         for (int i=0; i < (3-valorConvertidoParaBinario.length()); i++) {
            sb.append("0");
     }
      }
      
      sb.append(valorConvertidoParaBinario);
      posicao++;
   }
 
   return sb.toString();
}
    public static int converteOctalParaDecimal(String valorOctal) {
   int valor = 0;

   for (int i=valorOctal.length(); i>0; i--) {
      valor += Integer.parseInt(valorOctal.charAt(i-1)+"")*Math.pow(8, (valorOctal.length()-i));
   }
 
   return valor;
}
    public static String converteOctalParaHexadecimal(String valorOctal) {
   int valorDecimal = converteOctalParaDecimal(valorOctal);
 
   return converteDecimalParaHexadecimal(valorDecimal);
}
}
