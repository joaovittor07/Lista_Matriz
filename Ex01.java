package Lista_de_Matriz;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* Faça um programa que peça ao usuário um valor inteiro impar entre 3 e 11 
		   (inclusive 3 e 11, valide esta entrada), após isto crie uma matriz quadrada 
		   (inteiros) do tamanho do número informado pelo usuário. Permita que o usuário 
		   informe os valores para cada uma das posições da matriz. Após isto calcula e 
		   mostre as seguintes informações sobre a matriz:
			   • Soma dos elementos;
		   	   • Média dos elementos (duas casas decimais);
		   	   • Maior valor;
		   	   • Menor valor;
		   	   • Contador de pares;
		   	   • Contador de ímpares;
		   	   • Soma da diagonal principal;
		   	   • Soma da diagonal secundária;
		   	   • Mostrar a Matriz (formatada); */
		
		Scanner s = new Scanner (System.in);
	
		System.out.print("Informe um Número Impar entre 3 e 11: ");
		int imp = s.nextInt();
		
		//DEFINI SE Nº É PAR OU IMPAR
		if(imp % 2 == 0) {
				
			System.out.print("\nNão é um Número Impar");	
			
		}else if((imp >= 3) && (imp <= 11)) {
			
			//CRIA A MATRIZ
			int[][] matriz = new int[imp][imp];
			
			for(int i = 0; i < imp; i++) {	
				
				for(int j = 0; j < imp; j++) {
				
					System.out.print("\nInforme o Valor da Posição [" + i + "] e [" + j + "]: ");
					
					matriz[i][j] = s.nextInt();
					
				}
			}
			
			//SOMA DOS ELEMENTOS
			int soma = 0;
			
			for(int i = 0; i < imp; i++) {	
				
				for(int j = 0; j < imp; j++) {
				
					soma =+ matriz[i][j];
					
					System.out.print("\nSoma dos Elementos: " + soma);
					
				}
		   }
			
			//MÉDIA DOS ELEMENTOS
			int media = 0;
			
			for(int i = 0; i < imp; i++) {	
				
				for(int j = 0; j < imp; j++) {
				
					media = soma / matriz[i][j];
					
					System.out.print("\nSoma dos Elementos: " + media);
					
				}
		   }
			
			//MAIOR E MENOR VALOR
			int menor = 0;
			int maior = 0;
			
			for(int i = 0; i < imp; i++) {	
				
				for(int j = 0; j < imp; j++) {
					
					if(matriz[i][j] < menor) {
						
					}
					
					if(matriz[i][j] > maior) {
						
					}
				}
		   }
			
            System.out.println("\nMaior número: " + maior);
            System.out.println("\nMenor número: " + menor);
            
            //CONTADORES DE PARES E IMPARES 
            int im = 0;
            int pa = 0;
            
            for(int i = 0; i < matriz.length; i++) {	
				
				for(int j = 0; j < matriz[i].length; j++) {
					
					if(matriz[i][j] % 2 == 0) {
						
						pa++;
						
					} else {
						
						im++;
						
					}
				}
            }
			
            System.out.println("\nContadores de Peres: " + pa);
            System.out.println("\nContadores de Impares: " + im);
            
            
            //DIGONAL PRINCÍPAL E SECUNDÁRIA
            int pri = 0;
            int sec = 0;
            
            for (int i = 0; i < matriz.length; i++) {
            	
            	pri += matriz[i][i];
            	
            	sec += matriz[i][matriz.length - 1 - i];
            }
            
            System.out.println("\nSoma da Diagonal Princípal: " + pri);
            System.out.println("\nSoma da Diagonal Secundária: " + sec);
            
            //MATRIZ FORMATADA
            for (int i = 0; i < matriz.length; i++) {
                
            	for (int j = 0; j < matriz[i].length; j++) {
                
            		System.out.print(matriz[i][j] + "\t"); // \t para separar elementos por tabulação
                }
                
            	System.out.println(); // Pula para a próxima linha após cada linha da matriz
            
            }
		}else {
			
			System.out.print("\nNão um Número Impar que está entre 3 a 11");
			
		}
		s.close();		
	}
	
}