package Lista_de_Matriz;

import java.io.*;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* Crie um programa que solicite o preço de cinco produtos em cinco supermercados
		   diferentes, ao final o programa deve mostrar:
			• Os preços em cada um dos supermercados;
			• A média de preço por produto;
			• A soma de preços por supermercado;
			• O valor total no supermercado mais barato e no mais caro;
		   Permitir gravar e ler estes dados de um arquivo. */
		
		Scanner s = new Scanner(System.in);
        
        // Matriz para armazenar os preços em cada supermercado
        double[][] prices = new double[5][5];
        
        // Solicitar os preços dos produtos em cada supermercado
        for (int i = 0; i < 5; i++) {
            
        	System.out.println("Supermercado " + (i + 1));
            
        	for (int j = 0; j < 5; j++) {
            
        		System.out.print("Digite o preço do produto " + (j + 1) + ": ");
                
        		prices[i][j] = s.nextDouble();
            }
            
        	System.out.println();
        }
        
        // Calcular e exibir estatísticas
        System.out.println("Preços em cada supermercado:");
        
        for (int i = 0; i < 5; i++) {
        
        	System.out.print("Supermercado " + (i + 1) + ": ");
            
        	for (int j = 0; j < 5; j++) {
            
            	System.out.print(prices[i][j] + " ");
            }
         
        	System.out.println();
        }
        
        double[] averagePrices = new double[5];
        double[] supermarketTotalPrices = new double[5];
        
        for (int i = 0; i < 5; i++) {
           
        	double sum = 0;
            
        	for (int j = 0; j < 5; j++) {
                
        		sum += prices[i][j];
            }
            
        	averagePrices[i] = sum / 5;
            
        	supermarketTotalPrices[i] = sum;
        }
        
        double cheapestSupermarket = Double.MAX_VALUE;
        double mostExpensiveSupermarket = Double.MIN_VALUE;
        
        for (int i = 0; i < 5; i++) {
            
        	cheapestSupermarket = Math.min(cheapestSupermarket, supermarketTotalPrices[i]);
            
        	mostExpensiveSupermarket = Math.max(mostExpensiveSupermarket, supermarketTotalPrices[i]);
        }
        
        System.out.println("\nMédia de preço por produto:");
        
        for (int i = 0; i < 5; i++) {
           
        	System.out.println("Produto " + (i + 1) + ": " + averagePrices[i]);
        }
        
        System.out.println("\nSoma de preços por supermercado:");
       
        for (int i = 0; i < 5; i++) {
            
        	System.out.println("Supermercado " + (i + 1) + ": " + supermarketTotalPrices[i]);
        }
        
        System.out.println("\nValor total no supermercado mais barato: " + cheapestSupermarket);
        
        System.out.println("Valor total no supermercado mais caro: " + mostExpensiveSupermarket);
        
        // Gravar os dados em um arquivo
        try {
           
        	FileWriter writer = new FileWriter("supermarket_prices.txt");
            
        	for (int i = 0; i < 5; i++) {
                
        		for (int j = 0; j < 5; j++) {
                  
        			writer.write(prices[i][j] + " ");
                }
               
        		writer.write("\n");
            }
            writer.close();
            
            System.out.println("\nDados gravados no arquivo 'supermarket_prices.txt'.");
        
        } catch (IOException e) {
            
        	System.out.println("Erro ao gravar o arquivo.");
        }
        
        // Ler os dados do arquivo
        try {
           
        	Scanner fileScanner = new Scanner(new File("supermarket_prices.txt"));
            
            System.out.println("\nLendo os dados do arquivo 'supermarket_prices.txt':");
            
            while (fileScanner.hasNextLine()) {
                
            	System.out.println(fileScanner.nextLine());
            }
            
            fileScanner.close();
        
        } catch (FileNotFoundException e) {
            
        	System.out.println("Arquivo não encontrado.");
        }
        
        s.close();

	}

}
