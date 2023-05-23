//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Programa por:
//  Heitor Maciel (32251661)
//  Davi Rodrigues (32266960)
//  Vinícius Magno (32223201)
//  Gabriel Braum (32224532)
//  Roberto Rinco (32269471)

// Referências:
//  Como checar se um arquivo existe: https://www.baeldung.com/java-file-directory-exists

// Imports
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApl2 {

    public static void main(String[] args) {
        LinkedListOriginal list = new LinkedListOriginal();
        DLinkedList fixedList = null;
        DLinkedList filteredGradedList = null;
        DLinkedList filteredNonGradedList = null;
        DLinkedList aboveAverageList = null;
        float average = 0;
        String dadosEntrada = ""; 
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

		while (!op.equals("0")) {

			// Limpa o console
			System.out.print("\033[H\033[2J");
			System.out.flush();

			// Exibe o menu            
			System.out.println(menu);
            op = scanner.next();

            switch (op) {
                case "1":
                    if(!Files.exists(Paths.get(args[0]))) {
                        System.out.println("\nO arquivo de entrada especificado '" + args[0] + "' nao existe.\n");
                        System.exit(1);
                    }
					else {
						System.out.println("\nO arquivo de entrada especificado '" + args[0] + "' existe.\n");
					}
					// Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "2":
                    try {
                        dadosEntrada = Data.loadTextFileToString(args[0]); 
                    } catch (Exception e) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ocorreu um erro ao ler o arquivo de entrada especificado '" + args[0] + "'.");
                        System.exit(1);
                    }
                    String[] linhasDadosLegados = dadosEntrada.split("\n");
                    for (int i=0 ; i < linhasDadosLegados.length; i++) { 
                        String[] dadosLegados = linhasDadosLegados[i].split("#"); 
                        list.append(Integer.parseInt(dadosLegados[0]), dadosLegados[1], Integer.parseInt(dadosLegados[2]), Integer.parseInt(dadosLegados[3]));
                    }
                    System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
                    System.out.println(list);
                    System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "3":
					// Verifica se a lista está vazia
					if (list.isEmpty()) {
						System.out.println("\nA lista está vazia. Não é possível converter uma lista vazia.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    fixedList = Operation.map(list);
                    System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
                    System.out.println(fixedList);
                    System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "4":
					// Verifica se a lista existe
					if (fixedList == null) {
						System.out.println("\nA lista não existe. Não é possível filtrar uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
                    System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
                    System.out.println(filteredGradedList);
                    System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "5":
					// Verifica se a lista existe
					if (fixedList == null) {
						System.out.println("\nA lista não existe. Não é possível filtrar uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
                    System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
                    System.out.println(filteredNonGradedList);
                    System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "6":
					// Verifica se a lista existe
					if (filteredGradedList == null) {
						System.out.println("\nA lista não existe. Não é possível calcular a média de uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    average = Operation.reduce(filteredGradedList);
					System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
					System.out.println(average);
					System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "7":
					// Verifica se a lista existe
					if (filteredGradedList == null) {
						System.out.println("\nA lista não existe. Não é possível filtrar uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
					System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
					System.out.println(aboveAverageList);
					System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "8":
					// Verifica se a lista existe
					if (fixedList == null) {
						System.out.println("\nA lista não existe. Não é possível mapear uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    contents = Operation.mapToString(fixedList);
					System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
					System.out.println(contents);
					System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "9":
					// Verifica se a o conteúdo da lista foi mapeado para uma string
					if (contents == "") {
						System.out.println("\nA lista ainda não foi mapeada para uma string. Não é possível salvar uma lista não mapeada.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
					try {
						Data.saveStringToTextFile("dados.csv", contents);
						System.out.println("Arquivo de saída 'dados.csv' salvo com sucesso.");
					} catch (Exception e) {
						System.out.println("Ocorreu um erro ao salvar o arquivo de saída 'dados.csv'.");
						System.exit(1);
					}   // Salva a string contents no arquivo dados.csv
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "10":
					// Verifica se a lista existe
					if (fixedList == null) {
						System.out.println("\nA lista não existe. Não é possível ordenar uma lista inexistente.\n");
						// Aguarda o ENTER para continuar
						System.out.println("Pressione ENTER para continuar...");
						scanner.nextLine();
						scanner.nextLine();
						break;
					}
                    Node test1 = fixedList.getNode("23.S1-999");
					System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

					Node test2 = fixedList.removeNode("23.S1-999");
					System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

					Node test3 = fixedList.getNode("23.S1-999");
					System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

					aboveAverageList.clear();
					System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList
							+ "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

					DLinkedList testList = new DLinkedList();
					testList.insert("ABC", "John Doe", 4.7f);
					testList.append("XYZ", "Jane Doe", 9.9f);
					testList.insert("321", "Test", 2.3f);
					testList.append("Nothing", "Yada yada yada", 99.9f);

					System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
					System.out.println("testList.getHead(): " + testList.getHead());
					System.out.println("testList.getTail(): " + testList.getTail());
					System.out.println("testList.removeHead(): " + testList.removeHead());
					System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
					System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
					System.out.println("testList.getHead(): " + testList.getHead());
					System.out.println("testList.getTail(): " + testList.getTail());
					System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
					System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
					System.out.println("testList.getHead(): " + testList.getHead());
					System.out.println("testList.getTail(): " + testList.getTail() + '\n');
					testList.insert("qwerty", "QWERTY", 1.2f);
					testList.append("WASD", "wasd", 3.4f);
					testList.insert("ijkl", "IJKL", 5.6f);
					testList.append("1234", "Um Dois Tres Quatro", 7.8f);
					System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
					testList.clear();
					System.out.println(
					">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
                    // Aguarda o ENTER para continuar
					System.out.println("Pressione ENTER para continuar...");
					scanner.nextLine();
					scanner.nextLine();
					break;
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
