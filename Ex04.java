package Lista_de_Matriz;

import java.io.*;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/* Nas Olimp�adas do IFC est�o ocorrendo v�rias competi��es, entre elas salto 
		   em dist�ncia, nesta competi��o cada atleta tem direito a cinco saltos, para 
		   valorizar o atleta mais constante � feita a m�dia dos saltos, desprezando o 
		   pior salto. Voc� foi contratado para implementar um sistema que far� o controle 
		   desta competi��o, utilizando o recurso de Matriz, resolva os itens abaixo:
			� Solicitar os cinco saltos de cada atleta;
			� Ap�s o atleta saltar mostrar a m�dia;
			� Permitir a utiliza��o do sistema por N atletas (informado no inicio da aplica��o);
			� Ao final, ou seja, ap�s os N atletas digitarem os saltos o programa deve mostrar:
			� Saltos de cada atleta, seguidos de sua m�dia;
			� A m�dia dos saltos do campe�o e do �ltimo lugar;
		  Permitir gravar e ler estes dados de um arquivo. */

        Scanner s = new Scanner(System.in);

        System.out.print("Digite o n�mero de atletas: ");
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

        System.out.println("\nSaltos e m�dias de cada atleta:");
        
        for (int i = 0; i < numAthletes; i++) {
        
        	System.out.print("Atleta " + (i + 1) + ": ");
            
        	for (int j = 0; j < 5; j++) {
            
        		System.out.print(jumps[i][j] + "m ");
            }
            
        	System.out.println(" - M�dia: " + averages[i] + "m");
        }

        double championAverage = Double.MIN_VALUE;
        double lastPlaceAverage = Double.MAX_VALUE;

        for (int i = 0; i < numAthletes; i++) {
            
        	championAverage = Math.max(championAverage, averages[i]);
            
        	lastPlaceAverage = Math.min(lastPlaceAverage, averages[i]);
        }

        System.out.println("\nM�dia dos saltos do campe�o: " + championAverage + "m");

        System.out.println("M�dia dos saltos do �ltimo lugar: " + lastPlaceAverage + "m");

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
             
    			writer.write("- M�dia: " + averages[i] + "m\n");
            }
            writer.close();
            
            System.out.println("\nDados gravados no arquivo 'jump_competition.txt'.");
        
    	} catch (IOException e) {
        
    		System.out.println("Erro ao gravar o arquivo.");
        
    	}
		
	}

}
