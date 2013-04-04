# Queue

## Goal

As efficiently as possible, implement a queue-like data structure with the following characteristics:

- Standard enqueue/dequeue operations
- Entries must be unique (like a set)
- Can get position of any entry in the queue relative to the front
- Can remove from anywhere by value

## How?

Good question. So far, I'm thinking that will involve a queue (represented currently by a doubly linked list), with a hash table from values to queue entries, enabling constant-time enqueueing (checking if a value is already in the queue first) and removal. Not sure how to keep track of positions when removal from the middle is possible. The best case might be `O(log(n))` for that if using a binary tree to store positions. The other option would be to have log removal (updating the tree early), giving constant time position.

## License

The MIT license. See LICENSE for full text.

