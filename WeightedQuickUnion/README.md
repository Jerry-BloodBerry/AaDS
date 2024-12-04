# Weighted Quick-Union Algorithm

Another variation of quick-union. This one is optimized and both the `Find` and `Union` operations
have the time complexity of *O(lg<sub>2</sub>N)*

## Description
To optimize the plain Quick-Union algorithm two improvements were used:

1. We are using **weighted implementation** meaning that when we perform the union we always attach the root of the
smaller tree to the root of the bigger tree. In this way the trees are smaller after union.
2. We are using **path compression** to further flatten the trees by optimizing the tree structure when we perform
`Union` and `Find` operations. We use a simple implementation where we set the parent of each element we visit while
searching for root to its grandparent, thereby halving the path.

## Complexity
### Initialization
*O(N)* - we only need one for loop
### Space
*O(N)* - we allocate two arrays of size n, one for sizes and one for ids
### Time
`Find` - *O(lg<sub>2</sub>N)*

`Union` - *O(lg<sub>2</sub>N)*

## Additional remarks
One can prove that the maximum depth of each of the elements after unions is lg<sub>2</sub>N.

The size of tree containing element x upon each union at least *DOUBLES*.

Size of tree containing x can double at most lg<sub>2</sub>N times since if you start with 1 and double lg<sub>2</sub>N
times you will end up with N.
