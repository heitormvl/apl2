// Imports
import java.nio.file.Files;
import java.nio.file.Paths;

public class Operation {

    // Verifica se o arquivo de entrada existe
    public static void checkFile(String filePath) {

        // Se o arquivo não existir, exibe mensagem de erro e encerra o programa
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("\nO arquivo de entrada especificado '" + filePath +
                               "' nao existe.\n");
            System.exit(1);
        }

        // Se o arquivo existir, exibe mensagem de sucesso
        else {
            System.out.println("\nO arquivo de entrada especificado '" + filePath + "' existe.\n");
        }
    }

    // Carrega os dados do arquivo de entrada para a lista
    public static void loadDataFromFile(String filePath, LinkedListOriginal list) {

        // Tenta ler o arquivo de entrada e carregar os dados para a lista
        try {
            String dadosEntrada =
                Data.loadTextFileToString(filePath); // Carrega o arquivo de entrada para uma string
            String[] linhasDadosLegados = dadosEntrada.split("\n"); // Separa as linhas da string

            // Para cada linha da string, separa os dados e adiciona na lista
            for (int i = 0; i < linhasDadosLegados.length; i++) {
                String[] dadosLegados =
                    linhasDadosLegados[i].split("#"); // Separa os dados da linha
                list.append(Integer.parseInt(dadosLegados[0]), dadosLegados[1],
                            Integer.parseInt(dadosLegados[2]),
                            Integer.parseInt(dadosLegados[3])); // Adiciona os dados na lista
            }

            // Exibe os dados originais
            System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
            System.out.println(list);
            System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
        }

        // Se ocorrer algum erro ao ler o arquivo de entrada, exibe mensagem de erro e encerra o
        // programa
        catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.println("Ocorreu um erro ao ler o arquivo de entrada especificado '" +
                               filePath + "'.");
            System.exit(1);
        }
    }

    // Converte os dados da lista para a nova representação
    public static DLinkedList convertList(LinkedListOriginal list, DLinkedList fixedList) {

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (list.isEmpty()) {
            System.out.println("\nA lista está vazia. Não é possível converter uma lista vazia.\n");
        }

        // Se a lista não estiver vazia, converte os dados para a nova representação
        else {
            fixedList = Operation.convert(list); // Converte os dados da lista

            // Exibe os dados convertidos
            System.out.println(
                ">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
            System.out.println(fixedList);
            System.out.println(
                "<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
        }

        return fixedList; // Retorna a lista convertida ou vazia
    }

    // Filtra a lista para remover os dados inválidos
    public static DLinkedList filterGradedList(DLinkedList fixedList) {
        DLinkedList filteredGradedList = new DLinkedList(); // Lista filtrada

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (fixedList.isEmpty()) {
            System.out.println(
                "\nA lista não existe. Não é possível filtrar uma lista inexistente.\n");
        }

        // Se a lista não estiver vazia, filtra os dados
        else {
            filteredGradedList =
                Operation.filterRemoveNonGraded(fixedList); // Filtra os dados da lista

            // Exibe os dados filtrados
            System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
            System.out.println(filteredGradedList);
            System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
        }

        return filteredGradedList; // Retorna a lista filtrada ou vazia
    }

    // Calcula a média das notas válidas
    public static void filterNonGradedList(DLinkedList fixedList,
                                           DLinkedList filteredNonGradedList) {

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (fixedList.isEmpty()) {
            System.out.println(
                "\nA lista não existe. Não é possível filtrar uma lista inexistente.\n");
            return;
        }

        // Se a lista não estiver vazia, filtra os dados
        else {
            filteredNonGradedList =
                Operation.filterRemoveGraded(fixedList); // Filtra os dados da lista

            // Exibe os dados filtrados
            System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
            System.out.println(filteredNonGradedList);
            System.out.println(
                "<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
        }
    }

    // Calcula a média das notas válidas
    public static float average(DLinkedList filteredGradedList, float average) {

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma média 0
        if (filteredGradedList.isEmpty()) {
            System.out.println(
                "\nA lista não existe. Não é possível calcular a média de uma lista inexistente.\n");
            return 0;
        }

        // Se a lista não estiver vazia, calcula a média
        else {
            average = Operation.reduce(filteredGradedList); // Calcula a média dos dados da lista

            // Exibe a média
            System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
            System.out.println(average);
            System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
        }

        return average; // Retorna a média ou 0
    }

    // Filtra a lista para remover as notas abaixo da média
    public static void aboveAverageList(DLinkedList filteredGradedList,
                                        DLinkedList aboveAverageList, float average) {

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (average == 0) {
            System.out.println(
                "\nA média não foi calculada. Não é possível filtrar uma lista sem a média.\n");
            return;
        }

        // Se a lista não estiver vazia, filtra os dados
        else {
            aboveAverageList = Operation.filterRemoveBelowAverage(
                filteredGradedList, average); // Filtra os dados da lista

            // Exibe os dados filtrados
            System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
            System.out.println("Média: " + average + "\n" + aboveAverageList);
            System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
        }
    }

    // Filtra a lista para remover as notas abaixo da média
    public static String toString(DLinkedList fixedList, String contents) {

        // Se a lista estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (fixedList.isEmpty()) {
            System.out.println(
                "\nA lista não existe. Não é possível mapear uma lista inexistente.\n");
            return "";
        }

        // Se a lista não estiver vazia, mapeia os dados
        else {
            contents = Operation.mapToString(fixedList); // Mapeia os dados da lista

            // Exibe os dados mapeados
            System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
            System.out.println(contents);
            System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
        }

        return contents; // Retorna a string mapeada ou vazia
    }

    // Salva a string mapeada em um arquivo CSV
    public static void saveCSV(String contents) {

        // Se a string estiver vazia, exibe mensagem de erro e retorna uma lista vazia
        if (contents == "") {
            System.out.println(
                "\nA lista ainda não foi mapeada para uma string. Não é possível salvar uma lista não mapeada.\n");
            return;
        }

        // Tenta salvar a string no arquivo CSV
        try {
            Data.saveStringToTextFile("dados.csv", contents);
            System.out.println("Arquivo de saída 'dados.csv' salvo com sucesso.");
        }

        // Se ocorrer um erro, exibe mensagem de erro e encerra o programa
        catch (Exception e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo de saída 'dados.csv'.");
            System.exit(1);
        }
    }

    // Testa os métodos da classe DLinkedList
    public static void test(DLinkedList fixedList, DLinkedList aboveAverageList) {

        Node test1 = fixedList.getNode("23.S1-999");
        System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 +
                           "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

        Node test2 = fixedList.removeNode("23.S1-999");
        System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 +
                           "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

        Node test3 = fixedList.getNode("23.S1-999");
        System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 +
                           "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

        aboveAverageList.clear();
        System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList +
                           "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

        DLinkedList testList = new DLinkedList();
        testList.insert("ABC", "John Doe", 4.7f);
        testList.append("XYZ", "Jane Doe", 9.9f);
        testList.insert("321", "Test", 2.3f);
        testList.append("Nothing", "Yada yada yada", 99.9f);

        System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList +
                           "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        System.out.println("testList.getHead(): " + testList.getHead());
        System.out.println("testList.getTail(): " + testList.getTail());
        System.out.println("testList.removeHead(): " + testList.removeHead());
        System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
        System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList +
                           "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        System.out.println("testList.getHead(): " + testList.getHead());
        System.out.println("testList.getTail(): " + testList.getTail());
        System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
        System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList +
                           "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        System.out.println("testList.getHead(): " + testList.getHead());
        System.out.println("testList.getTail(): " + testList.getTail() + '\n');
        testList.insert("qwerty", "QWERTY", 1.2f);
        testList.append("WASD", "wasd", 3.4f);
        testList.insert("ijkl", "IJKL", 5.6f);
        testList.append("1234", "Um Dois Tres Quatro", 7.8f);
        System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList +
                           "\n<<<<<<<<<< testList <<<<<<<<<<\n");
        testList.clear();
        System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList +
                           "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
    }

    // Converte os dados de uma LinkedListOriginal para uma DLinkedList
    public static DLinkedList convert(final LinkedListOriginal original) {

        // Cria uma nova lista e um novo nó
        DLinkedList list = new DLinkedList();
        NodeOriginal node = original.getHead();

        // Percorre a lista original enquanto o nó atual não for nulo
        while (node != null) {

            // Trata o ID
            int idInicial = node.getId();          // Obtém o ID inicial
            int primeiroDigito = idInicial / 100;  // Obtém o primeiro dígito do ID inicial
            boolean par = primeiroDigito % 2 == 0; // Verifica se o primeiro dígito é par
            String idNovo = "23.S" + (par ? "2" : "1") + "-" +
                            idInicial; // Cria o novo ID; Se o primeiro dígito for par, o semestre é
                                       // 2 e vice-versa

            // Trata a nota; Se a nota for inválida, atribui 99.9
            float nota = node.getInteiro() < 0 || node.getDecimo() < 0
                             ? 99.9f
                             : node.getInteiro() + node.getDecimo() / 10.0f;

            // Cria um novo nó e o insere na list
            list.append(idNovo, node.getNome(), nota);

            // Avança para o próximo nó
            node = node.getNext();
        }

        return list; // Retorna a lista convertida
    }

    // Calcula a média das notas de uma lista
    public static DLinkedList filterRemoveNonGraded(final DLinkedList fixedList) {

        // Cria uma nova lista e um novo nó
        DLinkedList list = new DLinkedList();
        Node node = fixedList.getHead();

        // Percorre a lista enquanto o nó atual não for nulo
        while (node != null) {

            // Se a nota for válida, insere o nó na lista
            if (node.getNota() != 99.9f) {
                list.append(node.getId(), node.getNome(), node.getNota());
            }

            // Avança para o próximo nó
            node = node.getNext();
        }

        return list; // Retorna a lista filtrada
    }

    // Filtra os nós que possuem notas abaixo da média
    public static DLinkedList filterRemoveGraded(final DLinkedList data) {

        // Cria uma nova lista e um novo nó
        DLinkedList list = new DLinkedList();
        Node node = data.getHead();

        // Percorre a lista enquanto o nó atual não for nulo
        while (node != null) {

            // Se a nota for válida, insere o nó na lista
            if (node.getNota() == 99.9f) {
                list.append(node.getId(), node.getNome(), node.getNota());
            }

            // Avança para o próximo nó
            node = node.getNext();
        }

        return list; // Retorna a lista filtrada
    }

    // Filtra os nós que possuem notas abaixo da média
    public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {

        // Cria uma nova lista e um novo nó
        DLinkedList list = new DLinkedList();
        Node node = data.getHead();

        // Percorre a lista enquanto o nó atual não for nulo
        while (node != null) {

            // Se a nota for válida, insere o nó na lista
            if (node.getNota() > average) {
                list.append(node.getId(), node.getNome(), node.getNota());
            }

            // Avança para o próximo nó
            node = node.getNext();
        }

        return list; // Retorna a lista filtrada
    }

    // Calcula a média das notas de uma lista
    public static float reduce(final DLinkedList data) {

        // Cria um novo nó e inicializa a soma total e o contador de nós
        Node node = data.getHead();
        float soma = 0;
        int count = 0;

        // Percorre a lista enquanto o nó atual não for nulo
        while (node != null) {
            soma += node.getNota(); // Soma a nota do nó atual à soma total
            count++;                // Incrementa o contador de nós
            node = node.getNext();  // Avança para o próximo nó
        }

        return soma / count; // Retorna a média das notas
    }

    // Converte uma lista em uma string
    public static String mapToString(final DLinkedList data) {

        // Cria um novo nó e inicializa a string
        Node node = data.getHead();
        String str = "";

        // Percorre a lista enquanto o nó atual não for nulo
        while (node != null) {
            str += node.getId() + ";" + node.getNome() + ";" + node.getNota() +
                   "\n";           // Concatena os dados do nó atual à string
            node = node.getNext(); // Avança para o próximo nó
        }

        return str; // Retorna a string
    }
}
