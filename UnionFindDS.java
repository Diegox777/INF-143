class UnionFind {
    private int p[]; // para almacenar los padres
    private int rank[];  // para mantener el árbol corto
    private int setSize[]; // para el tamaño de los conjuntos
    private int numOfSets; // cuantos conjuntos tenemos?
    public UnionFind(int n) { // constructor por defecto de la estructura
        p = new int[n];
        rank = new int[n];
        setSize = new int[n];
        numOfSets = n;
        for (int i = 0; i < n; i++) {
            p[i] = i;
            setSize[i] = 1;
        }
    }

    public int findSet(int i) { // buscamos a que conjunto pertence el elemento i
        if (p[i] == i)
            return i;
        return p[i] = findSet(p[i]);
    }

    public boolean isSameSet(int i, int j) { // para verificar si el elemento i esta en el mismo conjunto
        return findSet(i) == findSet(j);    // que el elemento j
    }

    public void unionSet(int i, int j) { // para unir dentro de un mismo conjunto al conjunto del elemento i 
        if (!isSameSet(i, j)) {         // y al conunto del elemento elemento j
            int x = findSet(i);
            int y = findSet(j);
            numOfSets--;
            if (rank[x] > rank[y]) {
                p[y] = x;
                setSize[x] += setSize[y];
            } else {
                p[x] = y;
                setSize[y] += setSize[x];
                if (rank[x] == rank[y]) rank[y]++;
            }
        }
    }
    
    public int numOfDisjointSets() { // devuelve el número de conjuntos
        return numOfSets;
    }

    public int sizeOfSet(int i) { // devuelve el número de elementos en el conjunto al que pertence el elemento i
        return setSize[findSet(i)];
    }
}

public class UnionFindDS {
    public static void main(String... blabla) {
        int n = 6; // inicialmente 6 conjuntos separados
        UnionFind unionFind = new UnionFind(n);
        System.out.println(unionFind.numOfDisjointSets());
        unionFind.unionSet(0, 1);
        unionFind.unionSet(2, 3);
        unionFind.unionSet(4, 5);
        System.out.println(unionFind.numOfDisjointSets());
        System.out.println(unionFind.isSameSet(0, 1));
        System.out.println(unionFind.isSameSet(0, 2));
        System.out.println(unionFind.sizeOfSet(1));
    }
}