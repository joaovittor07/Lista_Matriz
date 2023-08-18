package Lista_de_Matriz;

import java.io.*;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		/* Utilizando a estrutura de matriz, faça um programa que para um colégio que tem
		   N (deve ser informado no início do programa) alunos e estes são avaliados em 
		   duas provas. O programa deve permitir digitação do nome do aluno e das duas notas 
		   e após isto mostrar as seguintes informações:
	        • Nome e as duas Notas de cada aluno;
	        • A média de cada aluno;
	        • A maior e menor nota (nome do aluno junto);
	        • A maior e menor média (nome do aluno junto);
	        • A média geral da turma;
	        • O nome dos alunos acima e abaixo da Media Geral da Turma;
	       Permitir gravar e ler estes dados de um arquivo. */
		
		Scanner s = new Scanner(System.in);

        System.out.print("Digite o número de alunos: ");
        int numStudents = s.nextInt();

        String[] names = new String[numStudents];
        double[][] grades = new double[numStudents][2];
        double[] averages = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            
        	s.nextLine();
            
        	System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            
        		names[i] = s.nextLine();
            
            System.out.print("Digite a nota da primeira prova: ");
            
            	grades[i][0] = s.nextDouble();
            
            System.out.print("Digite a nota da segunda prova: ");
            
            	grades[i][1] = s.nextDouble();
            
            	averages[i] = (grades[i][0] + grades[i][1]) / 2;
        }

        System.out.println("\nInformações dos alunos:");
      
        for (int i = 0; i < numStudents; i++) {
        
        	System.out.println("Aluno: " + names[i] + ", Notas: " + grades[i][0] + " " + grades[i][1]);
        }

        double highestGrade = Double.MIN_VALUE;
        double lowestGrade = Double.MAX_VALUE;
        
        String highestGradeStudent = "";
        String lowestGradeStudent = "";

        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;
       
        String highestAverageStudent = "";
        String lowestAverageStudent = "";

        double totalSum = 0;

        for (int i = 0; i < numStudents; i++) {
        
        	totalSum += averages[i];
            
        	if (grades[i][0] > highestGrade) {
            
        		highestGrade = grades[i][0];
             
        		highestGradeStudent = names[i];
            }
            if (grades[i][1] > highestGrade) {
            
            	highestGrade = grades[i][1];
                
            	highestGradeStudent = names[i];
            }
            if (grades[i][0] < lowestGrade) {
             
            	lowestGrade = grades[i][0];
                
            	lowestGradeStudent = names[i];
            }
            if (grades[i][1] < lowestGrade) {
             
            	lowestGrade = grades[i][1];
                
            	lowestGradeStudent = names[i];
            }
            if (averages[i] > highestAverage) {
             
            	highestAverage = averages[i];
                
            	highestAverageStudent = names[i];
            }
            if (averages[i] < lowestAverage) {
             
            	lowestAverage = averages[i];
                
            	lowestAverageStudent = names[i];
            }
        }

        double classAverage = totalSum / numStudents;

        System.out.println("\nMaior nota: " + highestGradeStudent + " - " + highestGrade);
        System.out.println("Menor nota: " + lowestGradeStudent + " - " + lowestGrade);
        System.out.println("Maior média: " + highestAverageStudent + " - " + highestAverage);
        System.out.println("Menor média: " + lowestAverageStudent + " - " + lowestAverage);
        System.out.println("Média geral da turma: " + classAverage);

        System.out.println("\nAlunos acima da média geral:");
        for (int i = 0; i < numStudents; i++) {
          
        	if (averages[i] > classAverage) {
            
        		System.out.println(names[i]);
            }
        }

        System.out.println("\nAlunos abaixo da média geral:");

        for (int i = 0; i < numStudents; i++) {
        
        	if (averages[i] < classAverage) {
            
        		System.out.println(names[i]);
            }
        }

        saveToFile(names, grades);

        s.close();
    }

    public static void saveToFile(String[] names, double[][] grades) {
       
    	try {
        
    		FileWriter writer = new FileWriter("student_grades.txt");
            
    		for (int i = 0; i < names.length; i++) {
            
    			writer.write(names[i] + " " + grades[i][0] + " " + grades[i][1] + "\n");
            }
            writer.close();
            
            System.out.println("\nDados gravados no arquivo 'student_grades.txt'.");
        
    	} catch (IOException e) {
        
    		System.out.println("Erro ao gravar o arquivo.");
        }
		
	}

}
