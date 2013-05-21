package TreeIterator;

public class BufferImplement< T > implements IBuffer< T >
{
    private T[] buffer;
    private int in, out, count, size;

    public BufferImplement(int size)
    {
        this.in     = 0;  // In and Out are incremented every time and then modulo arithmetic
        this.out    = 0;  // to make sure that you get the correct index.
        this.count  = 0;  // Count increments, decrements on push and pop. No need for modulo.
        this.size   = size;
        this.buffer = ( T[] )new Object[ size ];
    }
    
    public synchronized void put( T d ) throws InterruptedException
    {
        while( count == size ) {
            wait();
        }
        buffer[ in ] = d;
        count++;
        in = (in + 1) % size;
        notifyAll();
    }

    public synchronized T getNext() throws InterruptedException
    {
        while( count == 0 ) {
            wait();
        }
        T elem = buffer[ out ];
        buffer[ out ] = null;
        count--;
        out = (out + 1) % size;
        notifyAll();
        return elem;
    }

    public synchronized boolean hasNext() throws InterruptedException
    {
        if( buffer[( out + 1 ) % size] == null ) {
            return false;
        } else {
            return true;
        }
    }
}
