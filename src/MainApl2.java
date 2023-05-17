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

public class MainApl2 {

    public static void main(String[] args) {
        LinkedListOriginal list = new LinkedListOriginal();

        System.out.print("\033[H\033[2J"); // Limpa a tela do terminal

        if(args.length == 0) {
            System.out.println("Nenhum arquivo de entrada foi especificado.");
            System.exit(1);
        } // Verifica se o arquivo de entrada foi especificado

        if(!Files.exists(Paths.get(args[0]))) {
            System.out.println("O arquivo de entrada especificado '" + args[0] + "' nao existe.");
            System.exit(1);
        } // Verifica se o arquivo de entrada existe

        String dadosEntrada = ""; // String que armazena os dados de entrada do arquivo dados.txt

        try {
            dadosEntrada = Data.loadTextFileToString(args[0]); 
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.println("Ocorreu um erro ao ler o arquivo de entrada especificado '" + args[0] + "'.");
            System.exit(1);
        }   // Carrega os dados do arquivo de entrada para a string dadosEntrada

        String[] linhasDadosLegados = dadosEntrada.split("\n"); // Separa os dados de entrada em linhas

        for (int i=0 ; i < linhasDadosLegados.length; i++) { 
            String[] dadosLegados = linhasDadosLegados[i].split("#"); 
            list.insert(Integer.parseInt(dadosLegados[0]), dadosLegados[1], Integer.parseInt(dadosLegados[2]), Integer.parseInt(dadosLegados[3]));
        } // Para cada linha de dados de entrada, separa os dados de acordo com o caractere '#' e insere na lista

        System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
        System.out.println(list);
        System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");

        // DLinkedList fixedList = Operation.map(list);
        // System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
        // System.out.println(fixedList);
        // System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");

        // DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
        // System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
        // System.out.println(filteredGradedList);
        // System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");

        // DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
        // System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
        // System.out.println(filteredNonGradedList);
        // System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

        // float average = Operation.reduce(filteredGradedList);
        // System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
        // System.out.println(average);
        // System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");

        // DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
        // System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
        // System.out.println(aboveAverageList);
        // System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");

        // String contents = Operation.mapToString(fixedList);
        // System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
        // System.out.println(contents);
        // System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");

        // // TODO: Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".

        // Node test1 = fixedList.getNode("23.S1-999");
        // System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

        // Node test2 = fixedList.removeNode("23.S1-999");
        // System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

        // Node test3 = fixedList.getNode("23.S1-999");
        // System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

        // aboveAverageList.clear();
        // System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList
        //         + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

        // DLinkedList testList = new DLinkedList();
        // // TODO: Inserir um nó no início da lista testList com os dados ("ABC", "John
        // // Doe", 4.7f).
        // // TODO: Inserir um nó no final da lista testList com os dados ("XYZ", "Jane
        // // Doe", 9.9f).
        // // TODO: Inserir um nó no início da lista testList com os dados ("321", "Test",
        // // 2.3f).
        // // TODO: Inserir um nó no final da lista testList com os dados ("Nothing", "Yada
        // // yada yada", 99.9f).
        // System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        // System.out.println("testList.getHead(): " + testList.getHead());
        // System.out.println("testList.getTail(): " + testList.getTail());
        // System.out.println("testList.removeHead(): " + testList.removeHead());
        // System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
        // System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        // System.out.println("testList.getHead(): " + testList.getHead());
        // System.out.println("testList.getTail(): " + testList.getTail());
        // System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
        // System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        // System.out.println("testList.getHead(): " + testList.getHead());
        // System.out.println("testList.getTail(): " + testList.getTail() + '\n');
        // // TODO: Inserir um nó no início da lista testList com os dados ("qwerty",
        // // "QWERTY", 1.2f).
        // // TODO: Inserir um nó no final da lista testList com os dados ("WASD", "wasd",
        // // 3.4f).
        // // TODO: Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL",
        // // 5.6f).
        // // TODO: Inserir um nó no final da lista testList com os dados ("1234", "Um Dois
        // // Tres Quatro", 7.8f).
        // System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        // testList.clear();
        // System.out.println(
        //         ">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
    }

}
