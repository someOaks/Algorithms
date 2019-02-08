package unionFind;

import edu.princeton.cs.algs4.UF;

/**
 * #2 Union-find with specific canonical element.

 Add a method find() to the union-find data type
 so that find(i) returns the largest element
 in the connected component containing i.
 The operations, union(), connected(), and find()
 should all take logarithmic time or better.

 For example, if one of the connected components is {1,2,6,9},
 then the find() method should return 9
 for each of the four elements in the connected components.

 * 0 1 2 3 4 5
 *
 * 0-2 2-5
 * 3-4
 *
 * 2
 */

public class UnionFindWithSpecificCanonicalElement extends UF {
    private int size;

    public UnionFindWithSpecificCanonicalElement(int n) {
        super(n);
        this.size = n;
    }

    public int find2(int n){
        int largest = n;

//        for(int i = n; i < size; i++){
//            if (this.connected(n, i)){
//                if (i >= n) {
//                    largest = i;
//                }
//            }
//        }

        for (int i = size-1; i > n; i-- ){
            if (this.connected(n, i)){
                return i;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        UnionFindWithSpecificCanonicalElement uf = new UnionFindWithSpecificCanonicalElement(6);
        uf.union(0,2);
        uf.union(2,5);
        uf.union(3,4);
        int res = uf.find2(3);
        System.out.println(res);
    }
}