/**
*  This class implements a priority queue by using methods for enqueueing, dequeueing
*  and peeking.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
 */

public class MyPriorityQueue{
	private MyMaxHeap myQ;

    public MyPriorityQueue(int n){
    /**
    * Constructor used if only the number of elements is specified.
    *@param n, the size of the queue.
    */
        myQ = new MyMaxHeap(n);
    }

	public MyPriorityQueue(Passenger [] arr, int n){
    /**
    *  Constructor used if the user specifies the array they want to turn
    *  into a priority queue and the size of the queue.
    *
    *@param arr[], Unsorted array which we will later turn into a Priority Queue.
    *@param n, The size of the queue.
    */  
        myQ = new MyMaxHeap(arr, n);
    }

    public boolean enqueue(Passenger o){
    /**
    * Adds an object to the front of the queue.
    *
    *@param o, The object being added to the queue.
    *@return true or false based on whether or not the operation was successful.
    */
    	return myQ.add(o);
    }

    public Passenger dequeue(){
    /**
    *  Removes and returns the object from the front of the queue.
    *
    *@return the passenger (object) at the front of the queue.
    */
    	return myQ.removeMax();
    }

    public Passenger peek(){
    /**
    *  Retrieves the head (or first passenger) of the priority queue without removing it.
    *
    *@return returns the passenger (object) that would have been removed.
    */
    	Passenger o;
    	o = myQ.removeMax();
    	myQ.add(o);
    	return o;
    }

    public void parse(){
    /**
    * See MyMaxHeap for explanation.
    */
        myQ.parse();
    }

    public boolean empty(){
    /**
    * Checks if the queue is empty.
    *
    *@return true or false based on whether the queue is empty.
    */
    	if(myQ.size() == 0)
            return true;
        return false;
    }

    public String toString(){
    /**
    * Returns a string form of the priority queue.
    */
    	return myQ.toString();
    }
}