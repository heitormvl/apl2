public class NodeOriginal {

    // Atributos
    private int id;
    private String nome;
    private int inteiro;
    private int decimo;
    private NodeOriginal next;

    // Construtor padrão
    public NodeOriginal() { this(-1, "", 0, 0, null); }

    // Construtor com parâmetros
    public NodeOriginal(int id, String nome, int inteiro, int decimo, NodeOriginal next) {
        this.id = id;
        this.nome = nome;
        this.inteiro = inteiro;
        this.decimo = decimo;
        this.next = next;
    }

    // Getters e setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getInteiro() { return inteiro; }

    public void setInteiro(int inteiro) { this.inteiro = inteiro; }

    public int getDecimo() { return decimo; }

    public void setDecimo(int decimo) { this.decimo = decimo; }

    public NodeOriginal getNext() { return next; }

    public void setNext(NodeOriginal next) { this.next = next; }

    // Método toString para exibição dos dados do nó
    @Override
    public String toString() {
        return "[dados: (" + id + ";" + nome + ";" + inteiro + ";" + decimo + ") | next: " + next +
            "]";
    }
}