import java.util.Arrays;

public class MinHeapTernario {

    public static void heapSort(int[] v) {
        buildMinHeap(v);
        int n = v.length;
        for (int i = n - 1; i > 0; i--) {
            // Troca o menor elemento no topo com o último
            swap(v, 0, i);
            // Ajusta a heap com tamanho reduzido
            sift(v, 0, i - 1);
        }
    }

    // Constrói o Min-Heap para um array ternário
    private static void buildMinHeap(int[] v) {
        int n = v.length;
        for (int i = n / 3; i >= 0; i--) {
            sift(v, i, n - 1);
        }
    }

    // Função para ajustar a heap de 3 filhos
    private static void sift(int[] v, int i, int n) {
        int esq = 3 * i + 1;   // Calcula o índice do primeiro filho
        int meio = 3 * i + 2;  // Calcula o índice do segundo filho
        int dir = 3 * i + 3;   // Calcula o índice do terceiro filho
        int menor = i;         // Supõe que o menor é o nó atual

        // Compara com o primeiro filho
        if (esq <= n && v[esq] < v[menor]) {
            menor = esq;
        }

        // Compara com o segundo filho
        if (meio <= n && v[meio] < v[menor]) {
            menor = meio;
        }

        // Compara com o terceiro filho
        if (dir <= n && v[dir] < v[menor]) {
            menor = dir;
        }

        // Se o menor não é o nó atual, faça a troca e continue ajustando a heap
        if (menor != i) {
            swap(v, i, menor);
            sift(v, menor, n);
        }
    }

    // Função para trocar dois elementos no array
    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void main(String[] args) {
        // Exemplo de array para ordenação
    
        int[] v = {12, 3, 18, 24, 5, 1, 7, 16, 9};

        System.out.println("Array original: " + Arrays.toString(v));

        // Ordena o array com Heap Sort ternário
        heapSort(v);

        // Exibe o array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(v));
    }
}
