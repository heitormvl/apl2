// Imports
import java.util.Scanner;

public class MainApl2 {

    public static void main(String[] args) {
        
        // Criação das listas
        LinkedListOriginal list = new LinkedListOriginal();
        DLinkedList fixedList = new DLinkedList();
        DLinkedList filteredGradedList = new DLinkedList();
        DLinkedList filteredNonGradedList = new DLinkedList();
        DLinkedList aboveAverageList = new DLinkedList();

        // Variáveis auxiliares
        float average = 0;
		String contents = "";
		String menu = 	"Menu:\n" +
						"1. Verificar o arquivo de entrada\n" +
						"2. Separar os valores do arquivo de entrada e exibir os dados do sistema legado\n" +
						"3. Converter os dados para a nova representação\n" +
						"4. Filtrar somente notas válidas\n" +
						"5. Filtrar somente notas ausentes\n" +
						"6. Calcula média das notas válidas\n" +
						"7. Filtrar notas acima da média\n" +
						"8. Mapear a lista para uma única string\n" +
						"9. Exportar CSV\n" +
						"10. Realizar testes\n" +
						"0. Sair\n\n" +
						"Digite a opção desejada: ";


        // Scanner para leitura de opções do menu
        Scanner scanner = new Scanner(System.in);
        String op = "";

        // Loop do menu
		while (!op.equals("0")) {

			// Limpa o console
			System.out.print("\033[H\033[2J");
			System.out.flush();

			// Exibe o menu            
			System.out.println(menu);
            op = scanner.next();

            // Tratamento da opção escolhida
            switch (op) {

                // Verificar o arquivo de entrada
                case "1":
                    try {
                        Operation.checkFile(args[0]);
                    } catch (Exception e) {         
                        System.out.println("\nErro ao ler: " + e.getMessage() + "\n");
                    }
                    // Aguarda o ENTER para continuar
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                // Separar os valores do arquivo de entrada e exibir os dados do sistema legado
                case "2":
                    // Operation.loadDataFromFile(args[0], list);
                    try {
                        Operation.loadDataFromFile(args[0], list);
                    } catch (Exception e) {         
                        System.out.println("\nErro ao ler: " + e.getMessage() + "\n");
                    }
                    // Aguarda o ENTER para continuar
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                // Converter os dados para a nova representação
                case "3":
                    fixedList = Operation.convertList(list, fixedList);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Filtrar somente notas válidas
                case "4":
                    filteredGradedList = Operation.filterGradedList(fixedList);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Filtrar somente notas ausentes
                case "5":
					Operation.filterNonGradedList(fixedList, filteredNonGradedList);
                    // Aguarda o ENTER para continuar
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                // Calcula média das notas válidas
                case "6":
					average = Operation.average(filteredGradedList, average);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Filtrar notas acima da média
                case "7":
					Operation.aboveAverageList(filteredGradedList, aboveAverageList, average);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Mapear a lista para uma única string
                case "8":
					contents = Operation.toString(fixedList, contents);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Exportar CSV
                case "9":
					Operation.saveCSV(contents);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Realizar testes
                case "10":
					Operation.test(fixedList, aboveAverageList);
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;

                // Sair
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;

                // Opção inválida
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        // Fecha o scanner
        scanner.close();
    }
}
