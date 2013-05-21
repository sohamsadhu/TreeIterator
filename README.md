An attempt to traverse a tree lazily, and then run a for loop, to feel as if going over a flat
tree.

There are two attempts at doing this, one in C# and another in Java.
In C# we use a yield key word. The yield keyword is bit restrictive in way that it can iterate
only over the items that implement IEnumerable interface. You tweak the get enumerator in the
collection class, to get the flat tree in the way you want. And then go over it.

The other attempt at doing it, is using the threads and bounded buffer. Implementation of the 
bounded buffer has been taken from author J.N Magee, from the website 
http://www.doc.ic.ac.uk/~jnm/book/book_applets/BoundedBuffer.html .

The idea here is that one thread goes over the tree in the way specified from pre, in or post 
order; and write it to the buffer. At the same time, the value is read from the buffer. The
walk over the tree and write to buffer is interuppted by the blocking nature of the buffer,
thus making it lazy, till the data is read.

The Java solution at present does not work. Have to fix that one.
