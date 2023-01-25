package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * 
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * @param <T>
 *          Generic object that LinkedStack will hold
 */
public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private Node<T> topNode;
    
    /**
     * new LinkedStack object
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    /**
     * clears the stack
     */
    @Override
    public void clear() {
        for (int i = size; i > 0; i--)
        {
            this.pop();
        }
        size = 0;
    }

    /**
     * checks to see if the bag is empty
     * @return true or false if the bag is empty or not,
     * respectively
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * returns the item at the top of the stack
     * @return the top item on the stack
     */
    @Override
    public T peek() {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * removes the top item in the stack, and returns it
     * @return the removed item
     */
    @Override
    public T pop() {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T removed = topNode.getData();
        topNode = topNode.next;
        size--;
        return removed;
    }

    /**
     * adds an item onto the stack
     * @param anEntry
     *          item being added to the stack
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * returns the size of the stack
     * @return the size of the stack
     */
    public int size()
    {
        return size;
    }
    
    /**
     * returns the elements in the stack in the form of a string
     * @return a string form of the stack
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Node<T> toAdd =  topNode;
        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) 
        {
            if (!firstItem) 
            {
                builder.append(", ");
            }
            else 
            {
                firstItem = false;
            }
            builder.append(String.valueOf(toAdd.getData()));
            toAdd = toAdd.getNextNode();
        }
        builder.append(']');
        return builder.toString();
    }
    
    private class Node<K>
    {
        private K data;
        private Node<K> next;
        
        /**
         * new Node object
         * @param arg0
         *          data of the new node
         */
        public Node(K arg0)
        {
            this.data = arg0;
            this.next = null;
        }
        
        /**
         * new Node object
         * @param arg0
         *          data of the new node
         * @param theNext
         *          what the new node will reference
         */
        public Node(K arg0, Node<K> theNext)
        {
            this.data = arg0;
            this.next = theNext;
        }
        
        /**
         * returns the next node in the chain
         * @return the next node in the chain
         */
        public Node<K> getNextNode()
        {
            return this.next;
        }
        
        /**
         * returns this node's data
         * @return this node's data
         */
        public K getData()
        {
            return data;
        }
        
        /**
         * sets this nodes next node
         * @param nextNode
         *          node that this node will reference
         */
        public void setNextNode(Node<K> nextNode)
        {
            this.next = nextNode;
        }
    }

}
