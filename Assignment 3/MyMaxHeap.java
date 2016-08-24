/**
*  This class implements a max heap data structure by using methods for 
*  adding, removing, and vewing the heap.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author    Henry Thomas 
 */

public class MyMaxHeap{
  private Comparable[]theHeap;
  private int size;


  public static void main(String[] args){
    /**
    *  Main method for testing.
    */
    Comparable[] arrTest0 = {15,32,63,74,14,6,27};
    System.out.println("arrTest0 length: " + arrTest0.length + " (This will be used in test2)");
    MyMaxHeap test1 = new MyMaxHeap();
    System.out.println("-----------------test1 array-------------------------");
    System.out.println("Adding 6 to test1...");
    if (test1.add(6))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 18 to test1...");
    if (test1.add(18))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 29 to test1...");
    if (test1.add(29))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 20 to test1...");
    if (test1.add(20))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 28 to test1...");
    if (test1.add(28))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 39 to test1...");
    if (test1.add(39))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    System.out.println("Adding 66 to test1...");
    if (test1.add(66))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    test1.parse();
    System.out.println("Removing max value...");
    test1.removeMax();
    test1.parse();
    System.out.println("-----------------test2 array-------------------------");
    MyMaxHeap test2 = new MyMaxHeap(arrTest0, 7);
    test2.parse();
    System.out.println("Removing max value...");
    test2.removeMax();
    test2.parse();
    System.out.println("Adding 100 to test2...");
    if(test2.add(100))
      System.out.println("Success!");
    else
      System.out.println("Failure!");
    test2.parse();
    }

  public MyMaxHeap(){
    /**
    * Default constructor for the Max Heap. Sets default capacity equal to 20 and default 
    *size to 0
    */
    theHeap = new Comparable[20];
    size = 0;
  }
  
  public MyMaxHeap(int cap){
    /**
    * Alternate constructor used if the user specifies the capacity of the heap.
    * Sets the capacity equal to cap.
    *
    *@param cap The desired capcity of the Max Heap.
    */
    if(cap < 0){
      cap = 0;
    }
    theHeap = new Comparable[cap];
    size = 0;
  }

  public MyMaxHeap(Comparable[] arr,int n){
    /**
    * Constructor used if the user specifies the array they want to turn into
    *a heap and the size of the heap.
    *
    *@param arr[] Unsorted array which we will later turn into a MaxHeap.
    *@param n The size of the heap.
    *
    */
    if(arr == null){
      theHeap = new Comparable[40];
      size = 0;
    }
    else{
      if(n < 0)
        n = 0;
      else if (n > arr.length)
        n = arr.length;
      theHeap = arr;
      size = n;
      buildHeap();
    }
  }

  public int size(){
    /**
    * Used for returning the size of the heap.
    *
    *@return Returns the integer size (the size of our heap).
    */
    return size;
  }

  public boolean add(Comparable i){
    /**
    * Adds i to the heap then sorts everything into the right place.
    *
    *@param i The comparable element being added to the heap.
    *@return true or false Returns a boolean value regarding whether i was added or not.
    */
    if(i == null)
      return false;
    if(size >= theHeap.length)
      this.expand();
    else if(size==0){
      theHeap[size++] = i;
      return true;
    }
    theHeap[size++] = i;
    shiftUp(size-1);
    return true;
  }
  
  public Comparable removeMax(){
    /**
    * Removes and returns the root (max value) of the heap.
    *
    *@return Max value that was removed from the heap.
    */
    if(size >= 1){
    Comparable tmp = theHeap[0];
    theHeap[0] = theHeap[size-1];
    size--;
    shiftDown(0);
    return tmp;
    }
    return null;
  }


  private void shiftDown(int i){
    /**
    * Recursively swaps a parent at index i with a child with value larger than the parent.
    *
    *@param i The index of the element being shifted down.
    */
    int lc;
    if(i < (size/2))
    {
      lc = 2*i+1;
      if(((lc + 1) < size) && ((theHeap[lc + 1].compareTo(theHeap[lc])) > 0))
        lc++;
      if((theHeap[lc].compareTo(theHeap[i])) > 0)
      {
        swap(lc, i);
        shiftDown(lc);
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
    int p;
    if ((i > 0)&&(i < size))
    {
      p = (i-1)/2;
      if((theHeap[i].compareTo(theHeap[p])) > 0)
      {
        swap(i,p);
        return shiftUp(p);
      }
    }
    return i;
  }
  
  private void swap(int x, int y){
    /**
    * Swaps to elements at positions x and y  in the heap with each other in the heap.
    *
    *@param x Position of first element.
    *@param y Position of second element.
    */
    Comparable tmp = theHeap[x];
    theHeap[x] = theHeap[y];
    theHeap[y] = tmp;
    return;
  }

  private void expand(){
    /**
    * Increases the capacity of the array. This is used if the size is 
    * greater than the capacity.
    *
    */
    int i;
    Comparable[] temp = new Comparable[2*theHeap.length];
    for(i = 0; i < theHeap.length; i++)
      temp[i] = theHeap[i];
    theHeap = temp;
  }
  
  private void buildHeap(){
    /**
    * Organizes the array into a heap.
    */
    int i;
    for(i = size/2-1;i >= 0;i--){
      shiftDown(i);
    }
  }

  public void parse(){
    /**
    * Prints the heap using the toString method.
    */
    for(int i = 0;i < size;i++){
      System.out.print(theHeap[i].toString() + " ");
    }
    System.out.println();
  } 
}
