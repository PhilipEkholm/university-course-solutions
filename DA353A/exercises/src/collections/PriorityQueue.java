package collections;

import java.util.Comparator;

/**
*	PriorityQueue
*	
*	PriorityQueue is another implementation of the interface
*	Queue. The priorityqueue implements the FiFo-structure of the Queue
*	datastructure, but also differs on objects by using priority.
*	
*	Objects to be prioritized will be compared to other objects through a
*	class that implements comparator which can either be passed into constructor.
*	If no class that implements Comparator has been passed the objects are
*	assumed to implement the Comparable interface.
*
*	@author Philip Ekholm
*	@crated 2017-03-04
*/

public class PriorityQueue<E> implements Queue<E>{
	private LinkedList<E> elements = new LinkedList<E>();
    private Comparator<E> comp;

    /**
	*	Constructor without arguments, which will instantiate
	*	a new PriorityQueue object. This implementation will
	*	uses a LinkedList to store nodes.
	*
	*	Classes instantiating a PriorityQueue without arguments are
	*	assumed to only store objects that implements Comparable.
    */

    public PriorityQueue(){
		this.comp = new Comp();
	}

	/**
	*	Constructor that takes a class that implements Comparator to
	*	compare objects by.
	*/
	
	public PriorityQueue(Comparator<E> comp){
        this.comp = comp;
	}

    /**
	*	Enqueue (insert) new elements (data-objects) to the queue
    *   by adding them to the end of the list. If the object passed
    *	is prioritized by Comparator it will be moved further into line
    *	after another object with the same priority.
    *   
    *   @param data data-object to insert into the queue
    */

	@Override
	public void enqueue( E data ) {
		 int 	index = 0,
				size = size(); 
		 
		 while (index<size && comp.compare(elements.get(index), data) <= 0) {
			 index++;
		 }
		 
		 elements.add(index, data);
	}

	/**
	*	Dequeue (remove) the element (data-object) currently first up
    *   ("first in line") on the list and return it wherever
    *   the method was called.
    *
    *   If an attempt is made to dequeue an empty queue QueueException
    *   will be thrown.
    *
    *   @return the element currently first in the queue.
    *   @throws QueueException if the queue is empty while attempting to dequeue.
	*/

	@Override
	public E dequeue() throws QueueException{
		if(isEmpty()) {
            throw new QueueException("dequeue: Queue is empty");
        }
		
        return elements.removeFirst();
	}

	/**
    *   Peek (get) the element (data-object) currently first up
    *   ("first in line") on the list. If an attempt is made to peek at
    *   an empty queue QueueException will be thrown.
    *
    *   @return the element currently first in the queue.
    *   @throws QueueException if the queue is empty while attempting to peek.
    */

	@Override
	public E peek() throws QueueException{
		if( size()==0 ) {
            throw new QueueException("peek: Queue is empty");
        }
        return elements.get(0);
	}

	/**
    *   Check whether the queue is empty or not.
    *
    *   @return true if the queue is empty, otherwise false.
    */

	@Override
	public boolean isEmpty() {
		return (size()<=0);
	}

	/**
    *   Return the size (length) of the list.
    *
    *   @return the current size of the list.
    */

	@Override
	public int size() {
		return elements.size();
	}

	/**
    *   The toString-method will return a string-object containing a print
    *   of objects containing properties (among else). The current
    *   implementation will use the toString of the LinkedList instead of
    *   of a new implementation.
    *
    *   @return the toString return value of LinkedList
    */
	
	@Override
	public String toString(){
		return elements.toString();
	}
	
	/**
	*	Comp is the default class that implements Comparator
	*	if no other class has been passed to constructor.
	*	Misuse of the class will result in a ClassCastException
	*/

	private class Comp implements Comparator<E>{
		@Override
		public int compare(E obj1, E obj2) {
			Comparable<E> com1 = (Comparable<E>)obj1;
			
			return com1.compareTo(obj2);
		}
	}
	
}





























