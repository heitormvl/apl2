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
            args = new String[1];
            args[0] = "dados.txt";
        } // Se nenhum argumento for passado, o arquivo de entrada padrão é dados.txt

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
            list.append(Integer.parseInt(dadosLegados[0]), dadosLegados[1], Integer.parseInt(dadosLegados[2]), Integer.parseInt(dadosLegados[3]));
        } // Para cada linha de dados de entrada, separa os dados de acordo com o caractere '#' e insere na lista

        System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
        System.out.println(list);
        System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");

        DLinkedList fixedList = Operation.map(list);
        System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
        System.out.println(fixedList);
        System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");

        DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
        System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
        System.out.println(filteredGradedList);
        System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");

        DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
        System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
        System.out.println(filteredNonGradedList);
        System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

        float average = Operation.reduce(filteredGradedList);
        System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
        System.out.println(average);
        System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");

        DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
        System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
        System.out.println(aboveAverageList);
        System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");

        String contents = Operation.mapToString(fixedList);
        System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
        System.out.println(contents);
        System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");

        try {
            Data.saveStringToTextFile("dados.csv", contents);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo de saída 'dados.csv'.");
            System.exit(1);
        }   // Salva a string contents no arquivo dados.csv

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

        // Presione enter para encerrar
        System.out.println("Pressione enter para encerrar...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar encerrar o programa.");
            System.exit(1);
        }
    }
}
