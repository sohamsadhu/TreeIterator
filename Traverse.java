package TreeIterator;

import java.util.Stack;
import java.util.EmptyStackException;
import java.lang.InterruptedException;

// This is the producer class for the buffer.
public class Traverse implements Runnable
{
    private BTree< Integer > node;
    private IBuffer< BTree< Integer > > B;

    public void inorder( BTree< Integer > root, IBuffer< BTree< Integer > > B )
    {
        run();
        this.node = root;
        this.B    = B;
    }

    public void run()
    {
        try
        {
            Stack< BTree< Integer > > s = new Stack< BTree< Integer > >();
            while( !s.empty() || node != null )
            {
                if( node != null )
                {
                    s.push( node );
                    node = node.getLeftChild();
                }
                else
                {
                    node = s.pop();
                    B.put( node );
                    node = node.getRightChild();
                }
            }
        }
        catch( EmptyStackException ese ) {}
        catch( InterruptedException iex ) {}
    }
}
