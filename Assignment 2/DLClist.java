/* I pledge my honor that I have abided by the Stevens honor system.
  Henry Thomas
*/
  
public class DLClist
{

  private DLNode head;
  private int size;

  public static void main (String[]args)
  {
    DLClist list = new DLClist();
    System.out.println("");
    System.out.println("");
    System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-Testing Empty List-=-=-=-=-=-=-=-=-=-=--=-=-");
    list.get();
    list.remove();
    list.showList();
    System.out.println("Size = " + list.size());
    System.out.println("");
    System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-Testing Add & Append-=-=-=-=-=-=-=-=-=-=--=-");
    list.add("B");
    list.add("C");
    list.add("D");
    list.append("A");
    list.add("D", 10);
    list.add("E", -1);
    list.showList();
    System.out.println("Size = " + list.size());
    System.out.println("");
    System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-Testing Get-=-=-=-=-=-=-=-=-=-=--=-=-");
    System.out.println("Getting object at head...");
    System.out.println(list.get());
    System.out.println("Getting object at index 1...");
    System.out.println(list.get(1));
    System.out.println("Getting last object..");
    System.out.println(list.getLast());
    System.out.println("");
    System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-Testing Remove-=-=-=-=-=-=-=-=-=-=--=-=-");
    list.remove();
    list.removeLast();
    list.remove(new Integer(1));
    list.remove(-1);
    list.showList();
    System.out.println("Size = " + list.size());
  }

//Initializes an empty list
  public DLClist()
  {
    size = 0;
    head = null;
  }

  // Adds o at position i, returns true if successful, false if not
  public boolean add(Object o, int i)
  {
    if((size == 0) || (i == 0))
      return add(o);
    if (i >= size)
      return append(o);
    if (o == null)
      return false;
    if (i < 0)
      i = Math.abs(size + i); //making sure i is within 0 and size
    i = i % size;
    DLNode temp;
    for (temp = head; temp.next != null && i > 0; i--)
      temp = temp.next;
    temp.next.prev = new DLNode(o, temp, temp.next);
    temp.next = temp.next.prev;
    size++;
    return true;
  }

  //Adds o at the head, returns true if successful, false if not
  public boolean add(Object o)
  {
    DLNode obj = new DLNode(o);
    if (size == 0)
    {
      obj.next = obj;
      obj.prev = obj;
      head = obj;
      head.prev = head;
    }
    obj.prev = head.prev;
    head.prev.next = obj;
    head.prev = obj;
    obj.next = head;
    head = obj;
    size++;
    return true;
  }


  //Adds o before the head, returns true if successful, false if not
  public boolean append(Object o)
  {
    if (o==null)
      return false;
    if (size==0)
    {
      return add(o);      
    }
    else    
    {
      DLNode obj = new DLNode(o);
      obj.prev = head.prev;
      head.prev.next = obj;
      head.prev = obj;
      obj.next = head;
    }
    size++;
    return true;
  }

  //Returns the object at position i from the head
  public Object get(int i)
  {
    if(size == 0)
      return null;
    if(i < 0)
      i = Math.abs(size + i); //making sure i is within 0 and size
    i = i % size;
    DLNode temp;
    for (temp = head; temp.next != null && i > 0; i--)
      temp = temp.next;
    return temp.data;
  }

  // Returns the object at the head
  public Object get()
  {
    if(size == 0)
      return null;
    else
      return head.data;
  }

  //Returns the object at the tail
  public Object getLast()
  {
    if(size == 0)
      return null;
    else
      return head.prev.data;
  }

  //Returns the list size
  public int size()
  {
    return size;
  }

  //Remove and return the element at the head
  public Object remove()
  {
    if(size > 0)
    {
      DLNode temp = head;
      head.prev.next = head.next; //setting the tail to point past the current head
      head.next.prev = head.prev; //setting the second node to bypass head
      head = head.next; //setting new head to the next object
      size --;
      return temp.data;
    }
    else
    {
      return null;
    }
  }

  //Remove and return the element at the tail
  public Object removeLast()
  {
    if(size > 0)
    {
      DLNode temp = head.prev;
      head.prev.prev.next = head; //sets the tail to point past the current head
      head.prev = head.prev.prev; //sets the second node to bypass head
      size --;
      return temp.data;
    }
    else
    {
      return null;
    }
  }

  //Remove the item from index i
  public Object remove(int i){
    if(size == 0)
      return null;
    if(i < 0)
      i = Math.abs(size + i); //checks that i is within 0 and size
    i = i % size;
    DLNode temp = head;
    for(int j = 0; j < size; j++)
    {
      if(j == i)
        break;
      temp = temp.next;
    }
    temp.prev.next = temp.next; //setting the tail to point past the current head
    temp.next.prev = temp.prev; //setting the second node to bypass head
    size --; //decrease list size by 1
    return temp.data;
  }

  //Removes the first iteration of o in the list and returns true. Returns false if o was not in the list
  public Object remove(Object o)
  {
    if(size == 0)
      return null;
    DLNode temp = head;
    for(int j = 0; j < size; j++)
    {
      if(temp.data.equals(o))
        break;
      temp = temp.next;
    }
    temp.prev.next = temp.next; //setting the tail to point past the current head
    temp.next.prev = temp.prev; //setting the second node to bypass head
    size --;
    return temp.data;
  }

  //Prints all the elements in the list using toString() method
  public void showList(){
    DLNode temp = head;
    for(int i = 0; i < size; i++)
    {
      System.out.println(temp.data.toString());
      temp = temp.next;
    }
  }

  // Private Inner Class
  //container for the info for defining node
  private class DLNode
  {
    public Object data;
    public DLNode next;
    public DLNode prev;

    //Creates a node holding o
    public DLNode(Object o)
    {
      data = o;
      next = null;
      prev = null;
    }

    //Creates a node holding o, with n as next and p as prev
    public DLNode(Object o, DLNode n, DLNode p)
    {
      data = o;
      next = n;
      prev = p;
    }
  }
} 