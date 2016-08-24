/**
*  This class implements a max heap data structure by using methods for 
*  adding, removing, and vewing the heap.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
 */

public class MyMaxHeap{
	private Passenger [] theHeap;
	private int size;

	public MyMaxHeap(int cap){
		/**
		* Constructor for the heap if only the capacity is provided.
		*
		*@param cap, the capacity for the heap.
		*/
		if (cap <= 0){
			cap = 25;
		}
		theHeap = new Passenger[cap];
		size = 0;
	}

	public MyMaxHeap(Passenger [] arr, int n){
		/**
	    * Constructor used if the user specifies the array they want to turn into
	    *a heap and the size of the heap.
	    *
	    *@param arr[], Unsorted array which we will later turn into a MaxHeap.
	    *@param n, The size of the heap.
	    *
	    */
		if (arr == null){
			theHeap = new Passenger[25];
			size = 0;
			return;
		}
		if (n < 0)
			n = 0;
		if (n > arr.length)
			size = arr.length;
		else
			size = n;
		theHeap = arr;
		buildHeap();
	}

	public int size(){
		/**
	    * Used for returning the size of the heap.
	    *
	    *@return Returns the integer size (the size of our heap).
	    */
		return size;
	}

	private void buildHeap(){
		/**
	    * Organizes the array into a heap.
	    */
		int i;
		for (i = ((size/2) - 1); i >= 0; i--)
			shiftDown(i);
	}

	public void parse(){
		/**
    	* Prints the heap using the toString method. Useful for testing.
    	*/
		System.out.println(toString());
	}

	private void shiftDown(int i){
		/**
	    * Recursively swaps a parent at index i with a child with value larger than the parent.
	    *
	    *@param i The index of the element being shifted down.
	    */
		int lc = i;
		int rc = i;
		int maxChild = i;
		if((i >= 0) && (i < (size/2))){
			lc = 2*i + 1;
			rc = 2*i + 2;
			maxChild = lc;
			if (rc < size && theHeap[rc].compareTo(theHeap[lc]) > 0){
				maxChild = rc;
			}
			if (theHeap[i].compareTo(theHeap[maxChild]) < 0){
				swap(i, maxChild);
				shiftDown(maxChild);
			}
		}
	}

	private int shiftUp(int i){
		/**
	    * Recursively swaps a child at index i with a parent with a value smaller than its own.
	    *
	    *@param i The index of the element being shifted up.
	    *@return int of the index where the element has been shifted up.
	    */
		if (i > 0 && i < size){
			int p = (i - 1)/2;
			if(theHeap[i].compareTo(theHeap[p]) > 0){
				swap(i, p);
			}
			return shiftUp(p);
		}
		return i;
	}

	public Passenger removeMax(){
		/**
	    * Removes and returns the root (max value) of the heap.
	    *
	    *@return Max value that was removed from the heap.
	    */
		if (size <= 0)
			return null;
		swap(0, size - 1);
		size--;
		shiftDown(0);
		return theHeap[size];
	}

	private void swap(int x, int y){
		/**
	    * Swaps two elements at positions x and y in the heap with each other in the heap.
	    *
	    *@param x Position of first element.
	    *@param y Position of second element.
	    */
		Passenger tmp;
		tmp = theHeap[x];
		theHeap[x] = theHeap[y];
		theHeap[y] = tmp;
	}

	private void expand(){
		/**
	    * Increases the capacity of the array. This is used if the size is 
	    * greater than the capacity.
	    *
	    */
		Passenger[] tmp;
		int i;
		tmp = new Passenger[theHeap.length * 2];
		for (i = 0; i < theHeap.length; i++)
			tmp[i] = theHeap[i];
		theHeap = tmp;
	}

	private int parent(int i){
		/**
		* Finds the parent of any node located at position i.
		*
		*@param i, the index of the child
		*@return index of the parent
		*/
		return (i / 2);
	}

	public boolean add(Passenger i){
		/**
		* Adds a passenger to the heap
		*
		*@param i, the index at which the passenger is to be added
		*@return true or false. True if passenger is added successfully false if not.
		*/
		if (i == null)
			return false;
		if (size >= theHeap.length)
			return false;
		if (size == 0){
			theHeap[size++] = i;
			return true;
		}
		theHeap[size++]= i;
		int j = size - 1;
		while(theHeap[j].compareTo(theHeap[parent(j)]) > 0){
			swap(j, parent(j));
			j = parent(j);
		}
		return i.compareTo(theHeap[j]) == 0;
	}

	public String toString(){
		/**
    	* Returns a string form of the max heap.
    	*
    	*@return string, The string form of the max heap
    	*/
		String msg = "";
		for(int i = 0; i < size; i++){
			if(i != 0)
				msg += ", ";
			msg += theHeap[i].toString();
		}
		return msg;
	}
}