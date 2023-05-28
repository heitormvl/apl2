public class LinkedListOriginal {
	
    // Atributos
	private NodeOriginal head;
	private NodeOriginal tail;
	private int count;
	
    // Construtor padrão
	public LinkedListOriginal() {
		head = null;
		tail = null;
		count = 0;
	}
	
    // Apaga todos os elementos da lista
	public void destroy() {
		clear();
	}
	
    // Insere um elemento no início da lista
	public void insert(int id, String nome, int inteiro, int decimo) {

        // Cria um novo nó e o inicializa com os parâmetros recebidos
		NodeOriginal node = new NodeOriginal(id, nome, inteiro, decimo, head);
		
        // Se a lista estiver vazia, o novo nó será também a cauda da lista
		if (isEmpty()) {
			tail = node;
		}
		
		head = node; // O novo nó passa a ser a cabeça da lista
		++count; // Incrementa o contador de elementos

	}
	
    // Insere um elemento no final da lista
	public void append(int id, String nome, int inteiro, int decimo) {

        // Cria um novo nó e o inicializa com os parâmetros recebidos
		NodeOriginal node = new NodeOriginal(id, nome, inteiro, decimo, null);
		
        // Se a lista estiver vazia, o novo nó será também a cabeça da lista
		if (isEmpty()) {
			head = node;
		}
        
        // Se a lista não estiver vazia, o novo nó será o próximo da cauda
        else {
			tail.setNext(node);
		}
		
		tail = node; // O novo nó passa a ser a cauda da lista
		++count; // Incrementa o contador de elementos

	}
	
    // Insere um elemento na posição especificada
	public NodeOriginal removeHead() {

        // Se a lista estiver vazia, retorna null
		if (isEmpty()) {
			return null;
		}
		
		NodeOriginal toRemove = head; // Guarda o nó a ser removido

		head = head.getNext(); // O próximo nó passa a ser a cabeça da lista
		--count; // Decrementa o contador de elementos
        
        // Se a lista estiver vazia, a cauda também deve ser atualizada
		if (isEmpty()) {
			tail = null;
		}
		
		toRemove.setNext(null); // Desconecta o nó a ser removido da lista
		return toRemove; // Retorna o nó removido

	}
	
    // Remove o elemento do final da lista
	public NodeOriginal removeTail() {

        // Se a lista estiver vazia, retorna null
		if (head == tail) {
			return removeHead();
        }

		NodeOriginal toRemove = head; // Guarda o nó a ser removido
		NodeOriginal previous = null; // Guarda o nó anterior ao nó a ser removido
        
        // Percorre a lista até o penúltimo nó
		while (toRemove != tail) {
			previous = toRemove; // Guarda o nó anterior ao nó a ser removido
			toRemove = toRemove.getNext(); // Avança para o próximo nó
		}
		
		tail = previous; // O nó anterior ao nó a ser removido passa a ser a cauda da lista
		tail.setNext(null); // Desconecta o nó a ser removido da lista
		--count; // Decrementa o contador de elementos
		
		toRemove.setNext(null); // Desconecta o nó a ser removido da lista
		return toRemove; // Retorna o nó removido

	}
	
    // Remove o elemento da posição especificada
	public NodeOriginal removeNode(int id) {

		NodeOriginal toRemove = head; // Guarda o nó a ser removido
		NodeOriginal previous = null; // Guarda o nó anterior ao nó a ser removido
        
        // Percorre a lista até encontrar o nó a ser removido
		while (toRemove != null && toRemove.getId() != id) {
			previous = toRemove; // Guarda o nó anterior ao nó a ser removido
			toRemove = toRemove.getNext(); // Avança para o próximo nó
		}
		
        // Se o nó a ser removido não foi encontrado, retorna null
		if (toRemove == null) {
			return null;
		}
		
        // Se o nó a ser removido for o primeiro da lista, remove-o da cabeça
		else if (toRemove == head) {
			return removeHead();
		}
		
        // Se o nó a ser removido for o último da lista, remove-o da cauda
        else if (toRemove == tail) {
			return removeTail();
		}
		
		previous.setNext(toRemove.getNext()); // O próximo nó do nó anterior ao nó a ser removido passa a ser o próximo nó do nó a ser removido
		--count; // Decrementa o contador de elementos
		
		toRemove.setNext(null); // Desconecta o nó a ser removido da lista
		return toRemove; // Retorna o nó removido

	}

    // Retorna o primeiro elemento da lista
	public NodeOriginal getHead() {
		return head;
	}
	
    // Retorna o último elemento da lista
	public NodeOriginal getTail() {
		return tail;
	}
	
    // Retorna o elemento da posição especificada
	public NodeOriginal getNode(int id) {

		NodeOriginal node = head; // Guarda o nó a ser retornado
        
        // Percorre a lista enquanto o nó não for nulo
		while (node != null) {

            // Se o nó a ser retornado for encontrado, retorna-o
			if (node.getId() == id) {
				return node;
			}

			node = node.getNext(); // Avança para o próximo nó
		}
		
		return null; // Se o nó a ser retornado não for encontrado, retorna null

	}
	
    // Retorna o número de elementos da lista
	public int count() {
		return count;
	}
	
    // Retorna true se a lista estiver vazia
	public boolean isEmpty() {
		return head == null;
	}
	
    // Remove todos os elementos da lista
	public void clear() {

        // Remove o primeiro elemento enquanto a lista não estiver vazia
		while (!isEmpty()) {
			removeHead();
		}

	}

    // Retorna uma rep  resentação da lista em String
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder(); // Cria um StringBuilder para concatenar a representação da lista
		
		sb.append("(" + count + ") \n"); // Adiciona o número de elementos da lista
		
		NodeOriginal node = head; // Guarda o nó atual
        
        // Percorre a lista enquanto o nó não for nulo e concatena a representação do nó
		while (node != null) {
			sb.append("(")
			.append(node.getId())
			.append(" # ")
			.append(node.getNome())
			.append(" # ")
			.append(node.getInteiro())
			.append(" # ")
			.append(node.getDecimo())
			.append(") -> \n");
			node = node.getNext(); // Avança para o próximo nó
		}

		sb.append("null."); // Adiciona null para indicar o fim da lista
		
		return sb.toString(); // Retorna a representação da lista em String

	}

}
