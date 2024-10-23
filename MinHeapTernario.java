import java.util.Arrays;

public class MinHeapTernario {

    private int[] heap;
    private int tamanho;
    private int capacidade;

    // Construtor que inicializa a capacidade e o heap
    public MinHeapTernario(int capacidade) {

        this.capacidade = capacidade;
        this.tamanho = 0;
        this.heap = new int[capacidade];

    }

    // retorna o índice do pai de um nó
    private int pai(int i) {

        return (i - 1) / 3;

    }

    // retorna o índice do filho
    private int filho(int i, int numFilho) {

        return 3 * i + numFilho;

    }

    // Função para inserir um novo elemento no heap
    public void inserir(int valor) {

        if (tamanho == capacidade) {    // Verifica se o heap está cheio
            System.out.println("O heap está cheio");
            return;
        }

        heap[tamanho] = valor;  // novo valor é colocado na última posição do heap
        tamanho++;  // tamanho incrementado.
        heapificarParaCima(tamanho - 1);   // para restaurar a propriedade do Min-Heap.

    }

    // Função para garantir que o heap mantenha a propriedade de Min-Heap ao subir
    private void heapificarParaCima(int i) {

        int indiceAtual = i;

        while (indiceAtual > 0 && heap[indiceAtual] < heap[pai(indiceAtual)]) {     // garante que não saia do limite do vetor

            trocar(indiceAtual, pai(indiceAtual));  // Se o valor do nó atual for menor que o do pai, eles são trocados
            indiceAtual = pai(indiceAtual);     // índice é atualizado para o índice do pai para continuar o processo até que a propriedade do heap seja restaurada

        }

    }

    // Função para remover e retornar o menor elemento (a raiz) do heap
    public int extrairMinimo() {

        if (tamanho == 0) {

            System.out.println("O heap está vazio, não é possível extrair o mínimo.");
            return Integer.MIN_VALUE; // Retorna um valor padrão minimo

        }
    
        int minimo = heap[0]; // O menor elemento é a raiz
        heap[0] = heap[tamanho - 1]; // Substitui a raiz pelo último elemento
        tamanho--; // Reduz o tamanho do heap
        heapificarParaBaixo(0); // Ajusta a estrutura do heap
    
        return minimo; // Retorna o menor elemento extraído

    }
    

    // Função para garantir que o heap mantenha a propriedade de Min-Heap ao descer
    private void heapificarParaBaixo(int i) {

        int menor = i;  // O índice do nó atual é armazenado como o menor.

        for (int j = 1; j <= 3; j++) {  // pra cada filho (1 a 3), verifica se existe e se é menor que o atual

            int indiceFilho = filho(i, j);  

            if (indiceFilho < tamanho && heap[indiceFilho] < heap[menor]) {

                menor = indiceFilho;

            }
        }

        // Se um filho menor for encontrado, troca com o nó atual e chama heapificarParaBaixo recursivamente.
        if (menor != i) {

            trocar(i, menor);
            heapificarParaBaixo(menor);

        }

    }

    // troca dois elementos
    private void trocar(int i, int j) {

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    // Função para ordenar o vetor usando Heap Sort
    public int[] ordenar() {

        int[] ordenado = new int[tamanho];  // armazena os elementos ordenados.
        int tamanhoOriginal = tamanho;  // garante que o tamanho original seja armazenado e nao sofra as mudancas durantes possiveis iterações

        // Extrair o mínimo repetidamente até que o heap esteja vazio
        for (int i = 0; i < tamanhoOriginal; i++) {

            ordenado[i] = extrairMinimo();

        }

        return ordenado;    // Retorna o vetor ordenado

    }

    public static void main(String[] args) {
        MinHeapTernario minHeap = new MinHeapTernario(10);

        minHeap.inserir(10);
        minHeap.inserir(9);
        minHeap.inserir(3);
        minHeap.inserir(18);
        minHeap.inserir(4);
        minHeap.inserir(1);
        minHeap.inserir(13);
        minHeap.inserir(29);
        minHeap.inserir(32);

        System.out.println("Heap apos as inserçoes:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(minHeap.heap, 0, minHeap.tamanho)));

        // Ordenar o vetor
        int[] vetorOrdenado = minHeap.ordenar();
        System.out.println("Vetor ordenado:");
        System.out.println(Arrays.toString(vetorOrdenado));
    }
}
