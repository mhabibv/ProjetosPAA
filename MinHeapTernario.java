import java.util.Arrays;

public class MinHeapTernario {

   //Função principal para ordenar o array   
    public static void heapSort(int[] v) {

        buildMinHeap(v); // Constrói o Min-Heap 
        int n = v.length; // tamanho do array.

        // remove o menor elemento do heap e o coloca na posição correta do array.
        for (int i = n - 1; i > 0; i--) {

            // Troca o menor elemento no topo (índice 0) com o último elemento do heap (índice i).
            swap(v, 0, i);
            // Ajusta a heap com tamanho reduzido (exclui o último elemento que já está em sua posição)
            sift(v, 0, i - 1);

        }
    }

    //Constrói um Min-Heap a partir do array fornecido
    private static void buildMinHeap(int[] v) {

        int n = v.length; // Obtém o tamanho do array.

        // Inicia a construção do heap a partir do último nó que possui filhos.
        for (int i = n / 3; i >= 0; i--) {

            sift(v, i, n - 1); // Ajusta o heap para cada nó começando do último.

        }

    }

    // Ajusta a heap para garantir a propriedade do Min-Heap
    private static void sift(int[] v, int i, int n) {		// i = inicio do nó, n = final do nó

        // Calcula os índices dos filhos do nó atual (nó i).
        int esq = 3 * i + 1;   // indice do primeiro filho.
        int meio = 3 * i + 2;  // indice do segundo filho.
        int dir = 3 * i + 3;   // indice do terceiro filho.
        int menor = i;         // Assume que o menor é o nó atual.

        // Compara com o primeiro filho.
        if (esq <= n && v[esq] < v[menor]) {
            menor = esq; // Atualiza menor se o primeiro filho for menor.
        }

        // Compara com o segundo filho.
        if (meio <= n && v[meio] < v[menor]) {
            menor = meio; // Atualiza menor se o segundo filho for menor.
        }

        // Compara com o terceiro filho.
        if (dir <= n && v[dir] < v[menor]) {
            menor = dir; // Atualiza menor se o terceiro filho for menor.
        }

        // Se o menor não é o nó atual, faz a troca e continua ajustando a heap.
        if (menor != i) {
            swap(v, i, menor); // Troca o nó atual com o menor filho.
            sift(v, menor, n);  // Recursivamente ajusta a subárvore afetada.
        }
    }

    //Troca dois elementos no array.
    private static void swap(int[] v, int i, int j) {			// i = primeiro elemento, j = segundo elemento
        int temp = v[i]; // Armazena o valor do primeiro elemento.
        v[i] = v[j];     // Atribui o valor do segundo elemento ao primeiro.
        v[j] = temp;     // Atribui o valor armazenado ao segundo elemento.
    }

    //Função para ordenar o array em ordem crescente.
    private static void ordemCrescente(int[] v) {

        // A função inverte o array, que já foi ordenado em ordem decrescente
        int n = v.length; // tamanho do array

        for (int i = 0; i < n / 2; i++) {
            swap(v, i, n - 1 - i); // Troca os elementos
        }
    }

    public static void main(String[] args) {

        // Exemplo de array para ordenação
        int[] v = {12, 3, 18, 24, 5, 1, 7, 16, 9};

        // Exibe o array original
        System.out.println("Array original: " + Arrays.toString(v));

        // Ordena o array com Heap Sort ternário
        heapSort(v);

        // Ordena o array em ordem crescente
        ordemCrescente(v);

        // Exibe o array ordenado em ordem crescente
        System.out.println("Array ordenado em ordem crescente: " + Arrays.toString(v));
    }
}
