class MergeSortK {

    // Método que mescla k subarrays de vet[].
    void merge(int vet[], int[] indices, int ini, int fim) {   // array original; array que contém os índices iniciais de cada subarray; índice inicial da parte do array que está sendo processada; índice final da parte do array que está sendo processada.

        int tam = fim - ini + 1;            // Tamanho total 
        int[] temporario = new int[tam];    // Armazena os elementos mesclados antes de copiá-los de volta para o array original  
        int[] indiceAtual = new int[indices.length];       // Cria um array para acompanhar o índice atual de cada subarray
        
        // Inicializa o índice atual para cada subarray
        for (int i = 0; i < indices.length; i++) {
            
            indiceAtual[i] = indices[i];            // inicialmente, cada subarray começará a partir do seu respectivo índice

        }
        
        int indiceTemporario = 0;   //  usado para rastrear a posição atual no array temporario
        int k = indices.length;     // número total de subarrays que estamos mesclando

        // Mescla os k subarrays
        while (indiceTemporario < tam) {    // continua enquanto houver elementos para mesclar (até que todos os elementos dos subarrays sejam adicionados ao array temporário)

            int indiceMinimo = -1;      // rastreia qual subarray contém o menor elemento atual
            int valorMinimo = Integer.MAX_VALUE;    // maior valor inteiro possível pois garante que qualquer valor encontrado nos subarrays será menor que valorMinimo na primeira iteração.

            for (int i = 0; i < k; i++) {   // percorre cada um dos k subarrays
                
                if (indiceAtual[i] <= fim && indiceAtual[i] < indices[i + 1]) {     // Verifica se o índice está dentro do limite do array

                    if (vet[indiceAtual[i]] < valorMinimo) { 

                        valorMinimo = vet[indiceAtual[i]];      // comparamos o valor correspondente no array vet com valorMinimo. Se for menor, atualiza valorMinimo e indiceMinimo para apontar para o subarray que contém o menor valor.
                        indiceMinimo = i;

                    }

                }
            }

            // Se um índice mínimo válido for encontrado, coloca o valor mínimo no array temporário 
            if (indiceMinimo != -1) {

                temporario[indiceTemporario++] = vet[indiceAtual[indiceMinimo]]; 
                indiceAtual[indiceMinimo]++;

            } else {

                break;  // Não há mais elementos para mesclar (todos os elementos foram processados)

            }
        }

        // Copia o array temporário de volta para o array original
        for (int i = 0; i < tam; i++) {     

            vet[ini + i] = temporario[i];

        }
    }



    // Função principal 
    void sort(int vet[], int ini, int fim, int k) {     // array que contém os elementos a serem ordenados; índice inicial; índice final; número de partes em que o array deve ser dividido.

        if (ini < fim) {       // verifica se há pelo menos dois elementos para ordenar. Se ini não for menor que fim, não há nada a fazer (o array já está ordenado ou é vazio).

            int tamParticao = (fim - ini + 1 + k - 1) / k; // calcula o tamanho da partição (arredondamento para cima)
            int[] indices = new int[k + 1];     // armazenar os índices que delimitam cada subarray e um índice extra para o final

            // Calcula os índices de cada subarray
            for (int i = 0; i < k; i++) {

                indices[i] = ini + i * tamParticao;

                // Limita o último índice para não ultrapassar r
                if (i == k - 1) {

                    indices[i + 1] = fim + 1;

                } else {

                    indices[i + 1] = Math.min(ini + (i + 1) * tamParticao, fim + 1);    // garante que não ultrapassamos o limite do array original

                }

            }

            // Ordena cada subarray
            for (int i = 0; i < k; i++) {

                if (indices[i] < indices[k]) { // Garante que não saímos do limite

                    sort(vet, indices[i], indices[i + 1] - 1, k);

                }

            }

            // Mescla as partições ordenadas
            merge(vet, indices, ini, fim);

        }
    }

    // imprimir o vetor
    static void printVet(int vet[]) {

        int n = vet.length;

        for (int i = 0; i < n; ++i)
            System.out.print(vet[i] + " ");

        System.out.println();

    }

    // Main
    public static void main(String args[]) {

        int vet[] = { 12, 5, 7, 23, 1, 99, 45 };    // vetor a ser ordenado
        int k = 3; // quantas partes dividir

        System.out.println("Vetor desordenado:");
        printVet(vet);

        // Chamada do Merge Sort
        MergeSortK ob = new MergeSortK();
        ob.sort(vet, 0, vet.length - 1, k);

        System.out.println("\nVetor ordenado:");
        printVet(vet);

    }

}
