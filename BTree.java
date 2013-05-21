package TreeIterator;

public class BTree< T >
{
    private T data;
    private BTree< T > L;
    private BTree< T > R;

    public BTree( T data, BTree< T > left, BTree< T > right )
    {
        this.data = data;
        this.L    = left;
        this.R    = right;
    }

    public T getData() { return data; }

    public BTree< T > getLeftChild() { return L; }

    public BTree< T > getRightChild() { return R; }
}
