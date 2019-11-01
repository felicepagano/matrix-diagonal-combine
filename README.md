**Matrix unraveling**

Given an MxN matrix of characters, write a method that returns a String which
contains the concatenation of all the matrix’s diagonals, from top to bottom,
right to left.

For example, input

|       |       |       |       |       |       |
|-------|-------|-------|-------|-------|-------|
|   1   |   A   |   5   |   7   |   B   |   N   |
|   2   |   B   |   6   |   8   |   K   |   R   |
|   5   |   Q   |   N   |   3   |   B   |   1   |

Output has to be: `1 A2 5B5 76Q B8N NK3 RB 1` as a result (with or
without spaces, doesn’t matter)

_This matrix show why shift could be a solution for the problem_
 
|       |       |       |
|-------|-------|-------|
| (0,0) |       |       |
| (0,1) | (1,0) |       |
| (0,2) | (1,1) | (2,0) |
| (0,3) | (1,2) | (2,1) |
| (0,4) | (1,3) | (2,2) |
| (0,5) | (1,4) | (2,3) |
|       | (1,5) | (2,4) |
|       |       | (2,5) |