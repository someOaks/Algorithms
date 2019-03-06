Intersection of two sets. Given two arrays a[] and b[], each containing
n distinct 2D points in the plane, design a subquadratic algorithm to
count the number of points that are contained both in array a[] and
array b[].

Решение через ХЕШ не подходит т.к. там все равно нужно все хешировать, а
потом проводить полный поиск по каждому элементу одного массыва с каждым
элементом другого массива, даже если и по хешу. Кароче, это будет О(n^2)
\+ O(?)hash.

Оптимальным решением будет отсортировать один из массивов и искать в нем
бинарным поиском элементы из вторго массива.