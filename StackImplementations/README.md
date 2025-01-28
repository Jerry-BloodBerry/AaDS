# Stack Implementations

## ArrayStack

This is a generic stack implementation based on arrays. We maintain the elements of the stack stored in the array
and also keep track of the size.

Because we use array we need to handle resizing efficiently. This can be done by the technique of `repeated doubling`.
In this technique we double the size of the array every time when the array is full, and we want to add a new element.
This way the total amortized cost is proportional to ~3N (linear complexity).

We can use this implementation if we only care for the total time in which our program executes - if that is the case it
will be more efficient than the `LinkedStack` implementation. For cases when we want each operation to be fast we should
use `LinkedStack`.

## LinkedStack

This is a generic stack implementation based on linked list data structure. We store the elements as nodes with reference
only to the next item. In this implementation there is no need for resizing - we only need to update the relevant pointers
after the `push` and `pop` operations.

This implementation is better for cases where we need every operation to execute in constant time.