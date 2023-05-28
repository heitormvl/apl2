public class Node {

    // Atributos
    private String id;
    private String nome;
    private float nota;
    private Node next;
    private Node prev;

    // Construtor padrão
    public Node() {
        this("", "", 0, null, null); 
    }

    // Construtor com parâmetros
    public Node(String id, String nome, float nota, Node next, Node prev) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.next = next;
        this.prev = prev;
    }

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Método toString para exibição dos nós
    @Override
    public String toString() {
        return (getPrev() == null? "null" : getPrev().getId()) + " <- " + "(" + getId() + ";" + getNome() + ";" + getNota() + ")" + " -> " + (getNext() == null? "null" : getNext().getId());
    }
}