## Search in a bitonic array.
 >An array is bitonic if it is comprised of an increasing sequence of
 integers followed immediately by a decreasing sequence of integers.
 Write a program that, given a bitonic array of n distinct integer
 values, determines whether a given integer is in the array.

> + Standard version: Use ~ 3lg⁡n compares in the worst case.
> + Signing bonus: Use ~ 2lg⁡n compares in the worst case (and prove
 that no algorithm can guarantee to perform fewer than ~2lg⁡n compares
 in the worst case).

Ура! Решено рекурсией!

Класс `TestFindInteger` тестирует сканер битонического массива следующими методами:
1) `testBitonicArrayFromConstant` - тестирует с помощью "ручных" массивов с ручными
параметрами и аргументами;
2) `testBitonicArrayFromFile` - тестирует указанное число раз (`NUMBER_OF_TESTS`)
сканер битонического массива  в цикле и записывает время выполнения поиска по
массиву, выводит среднее время поиска по свем итерациям. Входищий массив изымается
из файла, который генерируется с помощью класса `BitonicArrayGenerator`.

`BitonicArrayGenerator` - собственно генерирует битонический массив.

Размер массива задается константой `ARRAY_SIZE`. Числа в массиве не повторяются.