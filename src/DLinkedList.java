public class DLinkedList {

    // Atributos
    private Node head;
    private Node tail;
    private int count;

    // Construtor padrão
    public DLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    // Insere um elemento no início da lista
    public void insert(String id, String nome, float nota) {

        // Cria um novo nó e o inicializa com os parâmetros recebidos
        Node node = new Node(id, nome, nota, head, null);

        // Se a lista estiver vazia, o novo nó será também a cauda da lista
        if (isEmpty()) {
            tail = node;
        }

        // Se a lista não estiver vazia, o novo nó será o anterior da cabeça
        else {
            head.setPrev(node);
        }

        head = node; // O novo nó passa a ser a cabeça da lista
        ++count;     // Incrementa o contador de elementos
    }

    // Insere um elemento no final da lista
    public void append(String id, String nome, float nota) {

        // Cria um novo nó e o inicializa com os parâmetros recebidos
        Node node = new Node(id, nome, nota, null, tail);

        // Se a lista estiver vazia, o novo nó será também a cabeça da lista
        if (isEmpty()) {
            head = node;
        }

        // Se a lista não estiver vazia, o novo nó será o próximo da cauda
        else {
            tail.setNext(node);
        }

        tail = node; // O novo nó passa a ser a cauda da lista
        ++count;     // Incrementa o contador de elementos
    }

    // Insere um elemento na posição especificada
    public Node removeHead() {

        // Se a lista estiver vazia, retorna null
        if (isEmpty()) {
            return null;
        }

        Node toRemove = head; // Guarda a referência do nó a ser removido

        head = head.getNext(); // A cabeça passa a ser o próximo nó
        --count;               // Decrementa o contador de elementos

        // Se a lista não estiver vazia, o anterior da cabeça será null
        if (head != null) {
            head.setPrev(null);
        }

        // Se a lista estiver vazia, a cauda também será null
        else {
            tail = null;
        }

        toRemove.setNext(null); // O próximo do nó removido será null
        return toRemove;        // Retorna a referência do nó removido
    }

    // Remove o elemento do final da lista
    public Node removeTail() {

        // Se a lista estiver vazia, retorna null
        if (isEmpty()) {
            return null;
        }

        Node toRemove = tail; // Guarda a referência do nó a ser removido

        tail = tail.getPrev(); // A cauda passa a ser o anterior nó

        // Se a lista não estiver vazia, o próximo da cauda será null
        if (tail != null) {
            tail.setNext(null);
        }

        // Se a lista estiver vazia, a cabeça também será null
        else {
            head = null;
        }

        toRemove.setPrev(null); // O anterior do nó removido será null
        --count;                // Decrementa o contador de elementos

        return toRemove; // Retorna a referência do nó removido
    }

    // Remove o elemento da posição especificada
    public Node removeNode(String id) {

        Node toRemove = getNode(id); // Busca o nó com o ID especificado

        // Se o nó não existir, retorna null
        if (toRemove == null) {
            return null;
        }

        // Se o nó for a cabeça, remove a cabeça
        else if (toRemove == head) {
            return removeHead();
        }

        // Se o nó for a cauda, remove a cauda
        else if (toRemove == tail) {
            return removeTail();
        }

        Node prevNode = toRemove.getPrev(); // Guarda o nó anterior
        Node nextNode = toRemove.getNext(); // Guarda o próximo nó

        prevNode.setNext(nextNode); // O próximo do anterior será o próximo do nó removido
        nextNode.setPrev(prevNode); // O anterior do próximo será o anterior do nó removido

        toRemove.setPrev(null); // O anterior do nó removido será null
        toRemove.setNext(null); // O próximo do nó removido será null
        --count;                // Decrementa o contador de elementos

        return toRemove; // Retorna a referência do nó removido
    }

    // Retorna o primeiro elemento da lista
    public Node getHead() { return head; }

    // Retorna o último elemento da lista
    public Node getTail() { return tail; }

    // Retorna o elemento da posição especificada
    public Node getNode(String id) {

        Node node = head; // Começa a busca pelo primeiro nó

        // Percorre a lista enquanto o nó não for null
        while (node != null) {

            // Se o ID do nó for igual ao ID especificado, retorna o nó
            if (node.getId().equals(id)) {
                return node;
            }

            node = node.getNext(); // Avança para o próximo nó
        }

        return null; // Se não encontrar o nó, retorna null
    }

    // Retorna o número de elementos da lista
    public int count() { return count; }

    // Retorna true se a lista estiver vazia
    public boolean isEmpty() { return head == null; }

    // Remove todos os elementos da lista
    public void clear() {

        // Remove o primeiro elemento enquanto a lista não estiver vazia
        while (!isEmpty()) {
            removeHead();
        }
    }

    // Retorna uma representação da lista em String
    @Override
    public String toString() {

        StringBuilder sb =
            new StringBuilder(); // Cria um StringBuilder para concatenar a representação da lista

        sb.append("(" + count + ") \n"); // Adiciona o número de elementos da lista

        Node node = head; // Começa a busca pelo primeiro nó

        // Percorre a lista enquanto o nó não for nulo e concatena a representação do nó
        while (node != null) {
            sb.append(node.getPrev() == null ? "null" : node.getPrev().getId())
                .append(" <- ")
                .append("(")
                .append(node.getId())
                .append(";")
                .append(node.getNome())
                .append(";")
                .append(node.getNota())
                .append(")")
                .append(" -> ")
                .append(node.getNext() == null ? "null" : node.getNext().getId())
                .append("\n");
            node = node.getNext(); // Avança para o próximo nó
        }

        return sb.toString(); // Retorna a representação da lista
    }
}