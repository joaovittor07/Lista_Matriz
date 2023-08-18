package Lista_de_Matriz;

import java.io.*;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/* Nas Olimpíadas do IFC estão ocorrendo várias competições, entre elas salto 
		   em distância, nesta competição cada atleta tem direito a cinco saltos, para 
		   valorizar o atleta mais constante é feita a média dos saltos, desprezando o 
		   pior salto. Você foi contratado para implementar um sistema que fará o controle 
		   desta competição, utilizando o recurso de Matriz, resolva os itens abaixo:
			• Solicitar os cinco saltos de cada atleta;
			• Após o atleta saltar mostrar a média;
			• Permitir a utilização do sistema por N atletas (informado no inicio da aplicação);
			• Ao final, ou seja, após os N atletas digitarem os saltos o programa deve mostrar:
			• Saltos de cada atleta, seguidos de sua média;
			• A média dos saltos do campeão e do último lugar;
		  Permitir gravar e ler estes dados de um arquivo. */

        Scanner s = new Scanner(System.in);

        System.out.print("Digite o número de atletas: ");
        int numAthletes = s.nextInt();

        double[][] jumps = new double[numAthletes][5];
        double[] averages = new double[numAthletes];

        for (int i = 0; i < numAthletes; i++) {
      
        	System.out.println("\nAtleta " + (i + 1));
            
        	for (int j = 0; j < 5; j++) {
            
        		System.out.print("Digite o salto " + (j + 1) + " (em metros): ");
                
        		jumps[i][j] = s.nextDouble();
            }
            
        	averages[i] = calculateAverage(jumps[i]);
        }

        System.out.println("\nSaltos e médias de cada atleta:");
        
        for (int i = 0; i < numAthletes; i++) {
        
        	System.out.print("Atleta " + (i + 1) + ": ");
            
        	for (int j = 0; j < 5; j++) {
            
        		System.out.print(jumps[i][j] + "m ");
            }
            
        	System.out.println(" - Média: " + averages[i] + "m");
        }

        double championAverage = Double.MIN_VALUE;
        double lastPlaceAverage = Double.MAX_VALUE;

        for (int i = 0; i < numAthletes; i++) {
            
        	championAverage = Math.max(championAverage, averages[i]);
            
        	lastPlaceAverage = Math.min(lastPlaceAverage, averages[i]);
        }

        System.out.println("\nMédia dos saltos do campeão: " + championAverage + "m");

        System.out.println("Média dos saltos do último lugar: " + lastPlaceAverage + "m");

        saveToFile(jumps, averages);

        s.close();
    }

    public static double calculateAverage(double[] jumps) {
        
    	double sum = 0;
        
    	double minJump = Double.MAX_VALUE;
        
    	for (double jump : jumps) {
        
    		sum += jump;
            
    		minJump = Math.min(minJump, jump);
        }
        return (sum - minJump) / (jumps.length - 1);
    }

    public static void saveToFile(double[][] jumps, double[] averages) {
    
    	try {
        
    		FileWriter writer = new FileWriter("jump_competition.txt");
            
    		for (int i = 0; i < jumps.length; i++) {
            
    			for (int j = 0; j < 5; j++) {
                
    				writer.write(jumps[i][j] + " ");
                }
             
    			writer.write("- Média: " + averages[i] + "m\n");
            }
            writer.close();
            
            System.out.println("\nDados gravados no arquivo 'jump_competition.txt'.");
        
    	} catch (IOException e) {
        
    		System.out.println("Erro ao gravar o arquivo.");
        
    	}
		
	}

}
