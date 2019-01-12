# Interview Questions: Union–Find

1. **Social network connectivity**
2. **Union-find with specific canonical element**
3. **Successor with delete**

# Interview Questions: Analysis of Algorithms

1. **3-SUM in quadratic time.**

    Design an algorithm for the 3-SUM problem 
    that takes time proportional to n^2 in the worst case. 
    
    You may assume that you can sort the n integers 
    in time proportional to n^2 or better.

2. **Search in a bitonic array.**

    An array is bitonic 
    if it is comprised of an increasing sequence of integers 
    followed immediately by a decreasing sequence of integers. 

    Write a program that, 
    given a bitonic array of n distinct integer values, 
    determines whether a given integer is in the array.

    **Standard version:** Use ~ 3 lg n compares in the worst case.

    **Signing bonus:** Use ~ 2 lg n compares in the worst case 
    (and prove that no algorithm can guarantee 
    to perform fewer than ~ 2 lg n compares in the worst case).

3. **Egg drop.**

    Suppose that you have an n-story building (with floors 1 through n) 
    and plenty of eggs. 

    An egg breaks if it is dropped from floor T or higher 
    and does not break otherwise. 

    Your goal is to devise a strategy to determine the value of T 
    given the following limitations on the number of eggs and tosses:

        - Version 0: 1 egg, ≤T tosses.
        - Version 1: ∼1 lg n eggs and ∼1 lg n tosses.
        - Version 2: ∼lg T eggs and ∼2lg T tosses.
        - Version 3: 2 eggs and ∼2 sqrt(n) tosses.
        - Version 4: 2 eggs and ≤ c sqrt(T) tosses for some fixed constant cc.
