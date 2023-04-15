package com.unicamp.mc322.lab01;

import java.util.Scanner;

public class calculadora{
	
	public static void main(String[] args) {
		
		while(true) {
			Scanner input = new Scanner(System.in);
			int num = 0, opcao = 0;
			double val1 = 0, val2 = 0;
			
			System.out.printf("Digite 1 para somar\n");
			System.out.printf("Digite 2 para subtrair\n");
			System.out.printf("Digite 3 para multiplicar\n");
			System.out.printf("Digite 4 para dividir\n");
			System.out.printf("Digite 5 para calcular fatorial\n");
			System.out.printf("Digite 6 para verificar se um numero e primo\n");
			System.out.printf("Digite qualquer outro valor para sair do sistema\n");
			
			opcao = input.nextInt();
			
			if(opcao < 1 || opcao > 6) {
				
				System.out.printf("Encerrando programa.\n");
				break;
			}
			else if(opcao == 5 || opcao == 6) {
				
				num = input.nextInt();
			}
			else {
				
				val1 = input.nextDouble();
				val2 = input.nextDouble();
			}
			
			switch(opcao) {
			
				case 1:
					System.out.println(val1 + " + " + val2 + " = " + soma(val1, val2));
				break;
				
				case 2:
					System.out.println(val1 + " - " + val2 + " = " + subtracao(val1, val2));
				break;
				
				case 3:
					System.out.println(val1 + " x " + val2 + " = " + multiplicacao(val1, val2));
				break;
				
				case 4:
					System.out.println(val1 + " / " + val2 + " = " + divisao(val1, val2));
				break;
				
				case 5:
					System.out.println("O fatorial de " + num + " é " + fatorial(num));
				break;
				
				case 6:
					if(verificaPrimo(num) == true) {
						
						System.out.println(num + " é primo");
					}
					else {
						
						System.out.println(num + " não é primo");
					}
				break;
				
				default:					
			}
			
			System.out.printf("\n");
		}
	}
	
	private static double soma(double val1, double val2) {
		
		double res = val1 + val2;
		return res;
	}
	
	private static double subtracao(double val1, double val2) {
		
		double res = val1 - val2;
		return res;
	}
	
	private static double multiplicacao(double val1, double val2) {
		
		double res = val1 * val2;
		return res;
	}
	
	private static double divisao(double val1, double val2) {
		
		double res = val1 / val2;
		return res;
	}
	
	private static int fatorial(int num) {
		
		int fatorial = num;
		
		for(int i = num-1; i >= 1; i--) {
			
			fatorial *= i;
		}
		
		return fatorial;
	}
	
	private static boolean verificaPrimo(int num) {
		
		for(int i = 2; i < num; i++) {
			
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}