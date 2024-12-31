# Percolation

This is my solution for the course's "Percolation" assignment from module 2. It uses
`Weighted Quick Union Union Find` algorithm to:

1. Simulate percolation in some kind of physical system using a 2D array.
2. Estimate the percolation threshold using Monte-Carlo simulation to open sites at random

## Note on backwash

This solution solves the so-called "backwash" problem which arises when we connect
the virtual top site to the virtual bottom site and have an open site connected to bottom,
but not connected to top. In such situations using just one Union Find causes the
algorithm to provide wrong answers when asked whether some of the sites are full or
not. This can be solved by using another `union find` data structure that is only
connected to virtual top site, but not to the virtual bottom site.

The downside to this approach is that we need more memory to store the second union find.

There is another solution for this problem mentioned here:
https://stackoverflow.com/questions/61396690/how-to-handle-the-backwash-problem-in-percolation-without-creating-an-extra-wuf