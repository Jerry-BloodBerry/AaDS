# Quick-Find Algorithm

This algorithm lets us quickly check if two elements in a given set of elements are connected with each other.

## Intuition
When can we say that two elements are `connected` to each other? Well: they need to **share** something.

That something can be many things including a graph edge, some label or an **ID**.

The `connected` elements form what we call a group/component.

Let's consider the following example with graph edges:
```
1 - 5     2 - 7 - 6
 \          |       8
  4 - 3     9
```

We have three groups (or components) that consist of interconnected numbers:

- Group 1: (1,5,4,3)
- Group 2: (2,7,9,6)
- Group 3: (8)

Note that we consider the relation `connected` to be:
- **Reflexive**: p is in relation with itself
- **Symmetric**: if p is in relation with q then q is in relation with p
- **Transitive**: if p is in relation with q and q is in relation with r then p is in relation with r

## Operations
`Union(p, q)` - merge two elements p and q into one component r

`Find(p, q)` - check if elements are `connected` (directly or indirectly)

## Implementation
To implement Quick-Find we can utilize an integer indexed array. We initialize Quick-Find by assigning to each
element the value of its index:
<table>
    <thead>
        <tr>
            <td>Index</td>
            <td>0</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
        </tr>
        <tr>
            <td>Value</td>
            <td>0</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
        </tr>
    </thead>
</table>

This is the `ID array`. We assume that if elements share a common `Value` (ID) then they are connected.

To make a `Union` of two numbers we assign them a common id. For example if we want to make a union of `0` and `4` we set
the array element at index `4` to `0`:

<table>
    <thead>
        <tr>
            <td>Index</td>
            <td>0</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
        </tr>
        <tr>
            <td>Value</td>
            <td>0</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>0</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
        </tr>
    </thead>
</table>

If we want to link two components together we need to overwrite the ID values of one component with the ID values
of the other so that the resulting component elements all share an ID.

## Complexity
### Space
For space complexity of this we only need an array of `n` elements where `n` is the number of elements in our set.

So space complexity is: *O(n)*

### Time
#### Find
The `Find` operation only requires checking if elements at two array indexes are equal to each other.

So for `Find` the time complexity is: *O(1)*

#### Union
For `Union` the complexity is `O(n)` as we need to traverse the whole ID array in order to perform it.

## Pitfall
Imagine if we had to perform union `N` times on `N` components/objects. The complexity here is quadratic as we need N<sup>2</sup>
array accesses to perform this.

This is very ineffective and not scalable as the input set grows in size.