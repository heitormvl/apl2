// arquivo: src/apl2/DLinkedList.java

// Programa por:
//  Heitor Maciel (32251661)
//  Davi Rodrigues (32266960)
//  Vinícius Magno (32223201)
//  Gabriel Braum (32224532)
//  Roberto Rinco (32269471)

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {

    private Node head;
    private Node tail;
    private int count;

    // OPERAÇÃO: Método construtor
    // COMPORTAMENTO: Cria uma lista vazia.
    public DLinkedList() {

        head = null;
        tail = null;
        count = 0;

    }

    // OPERAÇÃO: insert(<dados da pessoa>)
    // COMPORTAMENTO: Aloca um Node que contém os <dados da pessoa> e insere o
    // novo nó no início da lista.
    public void insert(String id, String nome, float nota) {

        Node node = new Node(id, nome, nota, head, null);

        if (isEmpty()) {
            tail = node;
        }
        else {
            head.setPrev(node);
        }

        head = node;
        ++count;

    }

    // OPERAÇÃO: append(<dados da pessoa>)
    // COMPORTAMENTO: Aloca um Node que contém os <dados da pessoa> e insere o
    // novo nó no final da lista.
    public void append(String id, String nome, float nota) {
        
        Node node = new Node(id, nome, nota, null, tail);

        if (isEmpty()) {
            head = node;
        }
        else {
            tail.setNext(node);
        }

        tail = node;
        ++count;

    }

    // OPERAÇÃO: removeHead()
    // COMPORTAMENTO: Remove o nó do início da lista e retorna a referência do
    // nó removido.
    // Ou retorna null caso a lista esteja vazia.
    public Node removeHead() {
        
        if (isEmpty()) {
            return null;
        }

        Node toRemove = head;

        head = head.getNext();
        --count;

        if (head != null) {
            head.setPrev(null);
        }
        else {
            tail = null;
        }

        toRemove.setNext(null);
        return toRemove;

    }

    // OPERAÇÃO: removeTail()
    // COMPORTAMENTO: Remove o nó do final da lista e retorna a referência do
    // nó removido.
    // Ou retorna null caso a lista esteja vazia.
    public Node removeTail() {
        
        if (isEmpty()) {
            return null;
        }

        Node toRemove = tail;

        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        toRemove.setPrev(null);
        --count;

        return toRemove;

    }

    // OPERAÇÃO: removeNode(<ID da pessoa>)
    // COMPORTAMENTO: Remove o nó que contém o <ID da pessoa> da lista e retorna
    // a referência do nó removido.
    // Ou retorna null caso não exista um nó com <ID da pessoa>.
    public Node removeNode(String id) {

        Node toRemove = getNode(id);

        if (toRemove == null) {
            return null;
        }

        if (toRemove == head) {
            return removeHead();
        }

        if (toRemove == tail) {
            return removeTail();
        }

        Node prevNode = toRemove.getPrev();
        Node nextNode = toRemove.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        toRemove.setPrev(null);
        toRemove.setNext(null);
        --count;

        return toRemove;
    }

    // OPERAÇÃO: getHead()
    // COMPORTAMENTO: Retorna uma referência para o nó do início da lista.
    // Ou retorna null caso a lista esteja vazia.
    public Node getHead() {
        
        return head;

    }

    // OPERAÇÃO: getTail()
    // COMPORTAMENTO: Retorna uma referência para o nó do final da lista.
    // Ou retorna null caso a lista esteja vazia.
    public Node getTail() {
        
        return tail;

    }

    // OPERAÇÃO: getNode(<ID da pessoa>)
    // COMPORTAMENTO: Retorna uma referência para o nó que contém o <ID da pessoa>
    // da lista.
    // Ou retorna null caso não exista um nó com <ID da pessoa>.
    public Node getNode(String id) {
        
        Node node = head;

        while (node != null) {
            if (node.getId().equals(id)) {
                return node;
            }
            node = node.getNext();
        }

        return null;

    }

    // OPERAÇÃO: count()
    // COMPORTAMENTO: Retorna a quantidade de nós da lista.
    public int count() {
        
        return count;

    }

    // OPERAÇÃO: isEmpty()
    // COMPORTAMENTO: Retorna true se a lista estiver vazia ou false, caso
    // contrário.
    public boolean isEmpty() {
        
        return head == null;

    }

    // OPERAÇÃO: clear()
    // COMPORTAMENTO: Esvazia a lista, liberando a memória de todos os nós da lista.
    public void clear() {
        
        while (!isEmpty()) {
            removeHead();
        }

    }

    // OPERAÇÃO: toString()
    // COMPORTAMENTO: Retorna uma string com o conteúdo da lista (caso queira, use o
    // exemplo do método toString() da classe LinkedListOriginal).
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("(" + count + ") \n");

        Node node = head;
        while (node != null) {
            sb.append("(")
            .append(node.getId())
            .append(" ; ")
            .append(node.getNome())
            .append(" ; ")
            .append(node.getNota())
            .append(")\n");
            node = node.getNext();
        }
        sb.append("null.");

        return sb.toString();
    }

}