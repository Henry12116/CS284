public class DLClist
{
	private class DLNode
	{
		public Object data;
		public DLNode next;
		public DLNode prev;

// This will create node o
		public DLNode(Object o) 
		{
			data = o;
			next = null;
			prev = null;
		}

//This will create node o with a next and a previous pointer given n and p
		public DLNode(Object o, DLNode n, DLNode p)
		{
			data = o;
			next = n;
			prev = p;
		}
	}

	private DLNode head;
	private int size;

//This creates an initial list with a size of 0
	public DLClist()
	{
		size = 0;
		head = null;
	}

//This will add an object to the list at the given location of i
	public boolean add(Object o, int i)
	{
		if((size ==0) || (i==0))
			return add(o);
		if (i>= size)
			return append(o);
		if (o==null)
			return false;
		if (i<0)
			i = Math.abs(size+1);
		i = i%size;
		DLNode curr;
		for( curr=head; i>1; i--, curr=curr.next);
		curr.next.prev = new DLNode(o, curr, curr.next);
		curr.next = curr.next.prev;
		size++;
		return true;
	}

// This will add object o to the beginning of the list making it the new head
	public boolean add(Object o)
	{
		DLNode curr = new DLNode(o);
		if (size == 0)
		{
			curr.next = curr;
			curr.prev = curr;
			head = curr;
			head.prev=head;
		}
		curr.prev=head.prev;
		head.prev.next=curr;
		head.prev=curr;
		curr.next=head;
		head=curr;
		size++;
		return true;
	}

//This will add object o to the end of the list
	public boolean append(Object o)
	{
		DLNode curr= new DLNode(o);
		if (o==null)
			return false;
		if (size==0)
			return add(o);
		curr.prev= head.prev;
		head.prev.next= curr;
		head.prev= curr;
		curr.next = head;
		size++;
		return true;
	}

//This will get the data of the node in the i position
	public Object get(int i)
	{
		if (size==0)
			return null;
		if( i<0)
			i = Math.abs(size+1);
		i = i%size;
		DLNode curr;
		for (curr = head; curr.next!=null && i>0; i--)
			curr=curr.next;
		return curr.data;
	}

//This will get the data from the first node
	public Object get()
	{
		if (size == 0)
			return null;
		return head.data;
	}

//This will get the data from the last position
	public Object getLast()
	{
		if(size ==0)
			return null;
		return head.prev.data;
	}

//This will return the size of the list
	public int size()
	{
		if (size==0)
			return 0;
		return size;
	}

//This will remove the first item from the list
	public Object remove()
	{
		if(size <=0)
			return null;
		DLNode curr = head;
		head.prev.next = head.next;
		head.next.prev= head.prev;
		head = head.next;
		size--;
		return curr.data;
	}

//This will remove the last item from the list
	public Object removeLast()
	{
		if(size<=0)
			return null;
		DLNode curr = head.prev;
		head.prev.prev.next = head;
		head.prev= head.prev.prev;
		size--;
		return curr.data;
	}

// this will remove the item in the i'th position
	public Object remove(int i)
	{
		if (size == 0)
			return null;
		if (i<0)
			i = Math.abs(size+i);
		i = i%size;
		DLNode curr;
		for( curr=head; curr.next!=head.prev && i>1; i--)
				curr = curr.next;
		Object ret = curr.next.data;
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		size--;
		return ret;
	}

// this will run through and find object o and then remove it from the list
	public Object remove(Object o)
	{
		if (size==0)
			return null;
		DLNode curr= head;
		for(int i=0; i<size; i++)
		{
			if (curr.data.equals(o))
				break;
			curr = curr.next;
		}
		curr.prev.next=curr.next;
		curr.next.prev=curr.prev;
		size--;
		return curr.data;
	}

//This will display the list using tostring
	public void showList()
	{
		System.out.println(this.toString());
	}

	public String toString()
	{
		String result = "";
		DLNode curr = head;
		for(int i = 0; i < size; i++)
		{
			result += curr.data + ",";
			curr = curr.next;
		}
		return result;
	}


	public static void main (String[]args)
	{
		DLClist list = new DLClist();
		list.get();
		list.remove();
		list.showList();
		System.out.println("size: " + list.size());
		System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-");
		list.add("T");
		list.append("P");
		list.add("K");
		list.add("G",2);
		list.add("S",-2);
		list.get(2);
		list.get();
		list.getLast();
		System.out.println("size: " + list.size());
		list.showList();
		System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-");
		list.removeLast();
		list.remove(new Integer(3));
		list.remove(2);
		list.remove();
		System.out.println("size: " + list.size());
		list.showList();
	}

}