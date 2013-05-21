package TreeIterator;

import java.util.EmptyStackException;
import java.lang.InterruptedException;

public class Display implements Runnable
{
    IBuffer< BTree< Integer > > buf;

    public void show( IBuffer< BTree< Integer > > buf )
    {
        this.buf = buf;
        run();
    }

    public void run()
    {
        try
        {
            while( buf.hasNext() ) {
                System.out.print( buf.getNext().getData().toString() + " " );
            }
            System.out.println();
        }
        catch( InterruptedException iex ) {}
    }
}
