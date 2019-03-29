
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void isPermWhenArraysAreTheSame(){

        Permutation perm = new Permutation();

        int[] a = new int[]{1, 3, 2};
        int[] b = new int[]{1, 2, 3};

        assertEquals(true, perm.isPerm(a, b));
    }

    @Test
    public void isPermWhenArraysAreDifferent(){

        Permutation perm = new Permutation();

        int[] a = new int[]{1, 3, 7};
        int[] b = new int[]{1, 2, 3};

        assertEquals(false, perm.isPerm(a, b));
    }

    @Test
    public void isPermWhenArraysAreWithDifferentLength(){

        Permutation perm = new Permutation();

        int[] a = new int[]{3, 1, 4, 9, 0};
        int[] b = new int[]{1, 2, 3};

        assertEquals(false, perm.isPerm(a, b));
    }



}