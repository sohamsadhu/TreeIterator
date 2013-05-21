using System;
using System.Collections;
using System.Collections.Generic;

// Credits: Alex Aza http://stackoverflow.com/users/732945/alex-aza
// http://stackoverflow.com/questions/6234338/binary-search-tree-traversal-preorder
// The class over which you want to iterate, has to be a collection of type enumerable.
public class Tree< T > : IEnumerable< T >
{
    public T data;       // It will require to be generic type to conform to interface.
    public Tree< T > L;
    public Tree< T > R;

    public Tree( T data, Tree< T > left, Tree< T > right )
    {
        this.data = data;
        this.L    = left;
        this.R    = right;
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
    
    public IEnumerator< T > GetEnumerator()
    {
        if( L != null )
        {
            foreach( var node in L ) { // Have to use var, because compiler does not like type Tree<T>.
                yield return node;
            }
        }
        yield return data ;
        if( R != null )
        {
            foreach( var node in R ) {
                yield return node;
            }
        }
    }
}

public class TreeIterator
{
    public void display( Tree< int > root )
    {
        Console.WriteLine("In-order Traversal of tree is ");
        // The enumerator goes in in-order fashion, so we go that way.
        foreach( int data in root ) {
            Console.Write( data.ToString() + " " );
        }
    }

    public static void Main( string [] args )
    {
        Tree< int > T1 = new Tree< int >( 1, null, null ); 
        Tree< int > T2 = new Tree< int >( 3, null, null ); 
        Tree< int > T3 = new Tree< int >( 5, null, null ); 
        Tree< int > T4 = new Tree< int >( 7, null, null ); 
        Tree< int > T5 = new Tree< int >( 2, T1, T2 ); 
        Tree< int > T6 = new Tree< int >( 6, T3, T4 ); 
        Tree< int > T7 = new Tree< int >( 4, T5, T6 ); 
        TreeIterator t = new TreeIterator();
        t.display( T7 );
    }
}
