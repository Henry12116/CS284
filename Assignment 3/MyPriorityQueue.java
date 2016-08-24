/**
*  This class implements a priority queue by using methods for enqueueing, dequeueing
*  and peeking.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author    Henry Thomas 
 */

public class MyPriorityQueue{
	private MyMaxHeap theQueue;

	public static void main(String [] args){
    /**
    *  Main testing method.
    */
    	System.out.println("-----------------test1 array------------------------------");
    	System.out.println("Creating new priority queue...");
    	MyPriorityQueue test1 = new MyPriorityQueue();
    	
    	System.out.println("-----------------test1 enqueueing-------------------------");
    	System.out.println("Enqueuing 10...");
		if(test1.enqueue(10)){
			System.out.println("Success!");
		}else{
			System.out.println("Failure!");
		}
		test1.parse();

		System.out.println("Enqueuing 68...");
		if(test1.enqueue(68)){
			System.out.println("Success!");
		}else{
			System.out.println("Failure!");
		}
		test1.parse();

		System.out.println("-----------------test1 dequeueing-------------------------");
		System.out.println("Dequeuing...");
        System.out.println("Element removed: "+ test1.dequeue());
        test1.parse();

        System.out.println("Dequeuing...");
        System.out.println("Element removed: "+ test1.dequeue());
        test1.parse();

        System.out.println("-----------------test1 empty checking---------------------");
		System.out.println("Checking if queue is empty...");
    	if(test1.empty()){
    		System.out.println("Empty!");
    	}else{
    		System.out.println("Not Empty!");
    	}
        
        System.out.println("-----------------test1 peeking----------------------------");
    	System.out.println("Enqueuing 100...");
        if(test1.enqueue(100)){
            System.out.println("Success!");
        }else{
            System.out.println("Failure!");
        }
        System.out.println("Head of priority queue: "+ test1.peek());
    	test1.parse();
    }

	public MyPriorityQueue(){
	/**
    *  Default constructor for the priority queue. Sets the queue equal to 
    *  a max heap with capacity 20 and size 0.
    */
		theQueue = new MyMaxHeap();
	}

	public MyPriorityQueue(Comparable [] arr, int n){
	/**
    *  Consstructor used if the user specifies the array they want to turn
    *  into a priority queue and the size of the queue.
	*
	*@param arr[] Unsorted array which we will later turn into a Priority Queue.
	*@param n The size of the queue.
    */	
        theQueue = new MyMaxHeap(arr, n);
    }

    public boolean enqueue(Comparable o){
    /**
    *  Adds an object to the front of the queue.
    *
    *@param o The object being added to the queue.
    *@return true or false based on whether or not the operation was successful.
    */
    	return theQueue.add(o);
    }

    public Object dequeue(){
    /**
    *  Removes and returns the object from the front of the queue.
    *
    *@return the object at the front of the queue.
    */
    	return theQueue.removeMax();
    }


    public Object peek(){	
    /**
    *  Retrieves the head of the priority queue without removing it.
    *
    *@return returns the object that would have been removed.
    */
    	Comparable temp = theQueue.removeMax();
		theQueue.add(temp);
		return temp;
	}


    public boolean empty(){
    /**
    *  Checks if the queue is empty.
    *
    *@return true or false based on whether the queue is empty.
    */
    	if(theQueue.size() > 0)
            return false;
        return true;
    }

    public void parse(){
    /**
    * See MyMaxHeap for explanation
    */
        theQueue.parse();
    }
}