**Matrix unraveling**

Given an m x n matrix of characters, write a method that returns a String which
contains the concatenation of all the matrix’s diagonals, from top to bottom,
right to left.

For example, input


`1 A 5 7 B N`

`2 B 6 8 K R`

`5 Q N 3 B 1`


Output has to be: `1 A2 5B5 76Q B8N NK3 RB 1` as a result (with or
without spaces, doesn’t matter)
 
|   0   |   1   |   2   |
|-------|-------|-------|
| (0,0) |       |       |
| (0,1) | (1,0) |       |
| (0,2) | (1,1) | (2,0) |
| (0,3) | (1,2) | (2,1) |
| (0,4) | (1,3) | (2,2) |
| (0,5) | (1,4) | (2,3) |
|       | (1,5) | (2,4) |
|       |       | (2,5) |


0 01 012 012 012 012 12 2
0 10 210 321 432 543 54 5

00
01 10
02 11 20
03 12 21
04 13 22
05 14 23
15 24
25