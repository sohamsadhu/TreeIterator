package TreeIterator;

public interface IBuffer< T >
{
    public void put( T d ) throws InterruptedException;

    public T getNext() throws InterruptedException;

    public boolean hasNext() throws InterruptedException;
}
