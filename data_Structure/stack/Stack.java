package data_Structure.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    //Head node
    private Node head;

    //element number
    private int N;

    private class Node{
        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    //initialize
    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }

    //if the stack is empty
    public boolean isEmpty(){

        return N==0;
    }


    public int size(){
        return N;
    }

    //push element
    public void push(T t){
        Node oldFirst=head.next;
        Node newNode=new Node(t,null);
        head.next=newNode;
        newNode.next=oldFirst;
        N++;
    }

    public T pop(){

        Node oldFirst=head.next;
        if(oldFirst==null){
            return null;
        }

        head.next=oldFirst.next;

        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
       private Stack.Node n;
       public SIterator(){
           this.n=head;
       }
        @Override
        public boolean hasNext() {
           return n.next!=null;
        }

        @Override
        public Object next() {
           n=n.next;
           return n.item;
        }
    }
}
