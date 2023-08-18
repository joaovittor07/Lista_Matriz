package Lista_de_Matriz;

import java.io.*;

import java.util.*;

public class Ex05 {

	public static void main(String[] args) {
		/* Criar uma loteria com 6 números de 1 a 60. Solicitar ao usuário quantas 
		   cartelas deseja preencher criar uma matriz deste tamanho para armazenar 
		   os valores que serão criados aleatoriamente. No final analisar cada uma 
		   das cartelas e mostrar ao lado do números (ordenados em ordem crescente 
		   e não repetidos dentro da mesma cartela) o total de acertos. Permitir 
		   gravar e ler estes dados de um arquivo. */
		
		Scanner s = new Scanner(System.in);

        System.out.print("Digite a quantidade de cartelas: ");
        int numCards = s.nextInt();
       
        int[] winningNumbers = generateWinningNumbers();

        int[][] cards = new int[numCards][6];

        for (int i = 0; i < numCards; i++) {
        
        	cards[i] = generateCardNumbers();
        }

        System.out.println("\nNúmeros premiados: " + Arrays.toString(winningNumbers));

        for (int i = 0; i < numCards; i++) {

        	int[] sortedCard = Arrays.copyOf(cards[i], 6);

        	Arrays.sort(sortedCard);

            int numMatches = countMatches(sortedCard, winningNumbers);
            
            System.out.print("\nCartela " + (i + 1) + ": ");

            for (int num : sortedCard) {
            
            	System.out.print(num + " ");
            }
            
            System.out.println(" - Total de acertos: " + numMatches);
        }

        saveToFile(cards, winningNumbers);

        s.close();
    }

    public static int[] generateWinningNumbers() {
        
    	Random random = new Random();
        
    	int[] numbers = new int[6];
        
    	for (int i = 0; i < 6; i++) {
        
    		numbers[i] = random.nextInt(60) + 1;
        }
        
    	return numbers;
    }

    public static int[] generateCardNumbers() {

    	Random random = new Random();
        
    	int[] numbers = new int[6];
        
    	Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 6) {

        	int num = random.nextInt(60) + 1;
            
        	if (!numberSet.contains(num)) {
            
        		numberSet.add(num);
            }
        }

        int i = 0;

        for (int num : numberSet) {
        
        	numbers[i++] = num;
        }

        return numbers;
    }

    public static int countMatches(int[] card, int[] winningNumbers) {

    	int count = 0;
        
    	for (int num : card) {
        
    		if (Arrays.binarySearch(winningNumbers, num) >= 0) {
            
    			count++;
            }
        }
        return count;
    }

    public static void saveToFile(int[][] cards, int[] winningNumbers) {

    	try {
        
    		FileWriter writer = new FileWriter("lottery_results.txt");
            
    		writer.write("Números premiados: " + Arrays.toString(winningNumbers) + "\n\n");

            for (int i = 0; i < cards.length; i++) {

            	int[] sortedCard = Arrays.copyOf(cards[i], 6);
                
            	Arrays.sort(sortedCard);

                int numMatches = countMatches(sortedCard, winningNumbers);

                writer.write("Cartela " + (i + 1) + ": ");

                for (int num : sortedCard) {
                
                	writer.write(num + " ");
                }
            
                writer.write("- Total de acertos: " + numMatches + "\n");
            }
            
            writer.close();
            
            System.out.println("\nDados gravados no arquivo 'lottery_results.txt'.");
        
    	} catch (IOException e) {
        
    		System.out.println("Erro ao gravar o arquivo.");
        }
		
	}
}
