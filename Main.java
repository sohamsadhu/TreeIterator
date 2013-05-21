package TreeIterator;

public class Main
{
    public static void main( String [] args )
    {
        BTree< Integer > T1 = new BTree< Integer >( 1, null, null ); 
        BTree< Integer > T2 = new BTree< Integer >( 3, null, null ); 
        BTree< Integer > T3 = new BTree< Integer >( 5, null, null ); 
        BTree< Integer > T4 = new BTree< Integer >( 7, null, null ); 
        BTree< Integer > T5 = new BTree< Integer >( 2, T1, T2 ); 
        BTree< Integer > T6 = new BTree< Integer >( 6, T3, T4 ); 
        BTree< Integer > T7 = new BTree< Integer >( 4, T5, T6 );

        IBuffer< BTree< Integer > > buf = new BufferImplement< BTree< Integer > >( 2 );
        Traverse T = new Traverse();
        T.inorder( T7, buf );
        Display D = new Display();
        D.show( buf );
    }
}
