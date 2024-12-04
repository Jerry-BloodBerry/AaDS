# Quick-Union

Quick-Union algorithm is a variation of Quick-Find algorithm that can be used for dynamic connectivity.

## Algorithm description

Same as before we need to implement two operations: `Union(p, q)` and `Find(p, q)`, but this time we are connecting
our elements into trees. When we make a union we set the root of element p to the root of element q.

At the beginning each element is its own root.

Find basically checks if two elements have the same root. If they do it means they are in the same component.

Example:
```
(0)  (1)  (2)  (3)  (4)  (5)

| Union(4,5)

(0)  (1)  (2)  (3)  (5)
                     |
                    (4)

| Union(4,2)

(0)  (1)  (2)  (3)
           |
          (5)
           |
          (4)

| Union(3,4)

(0)  (1)  (2)
         / |
       (3)(5)
           |
          (4)
```

## Complexity

### Space
Same as before space complexity is *O(n)*
### Time
`Find` time complexity in worst case is *O(n)* (including root function calls)

`Union` time complexity in worst case is also *O(n)* as for union we also need root function calls 