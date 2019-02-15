package successorWithDelete;

import edu.princeton.cs.algs4.QuickFindUF;

/**
 * #3 Successor with delete.

 Given a set of n integers S={0,1,...,n−1}      -->  0 1 2 3 4 5
 and a sequence of requests of the following form:

 - Remove x from S
 - Find the successorWithDelete of x: the smallest y in S such that y≥x.

 design a data type so that all operations (except construction)
 take logarithmic time or better in the worst case.


 x-> 3

 union(2, 5)
 x(3) -> n(5)

 isConnected(3, 5)

 2 - 3 - 0 1 3 4
 1 - 3 - 0 3 4

 */

public class SuccessorWithDelete {
    private static QuickFindUF uf;              // int[]

    public SuccessorWithDelete(int n) {
        this.uf = new QuickFindUF(n);
    }

    public void remove(int x){
        this.uf.union(x, x+1);
    }

    public int successor(int x){
        return uf.find(x);
    }

    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete(10); // 0 1 2 3 4 5 6 7 8 9

        System.out.println(swd.successor(3)); // 3 --> 3

        swd.remove(0);
        swd.remove(5);
        swd.remove(6);
        swd.remove(8);

        System.out.println(swd.successor(0));
        System.out.println(swd.successor(5));
        System.out.println(swd.successor(9));

    }
}
