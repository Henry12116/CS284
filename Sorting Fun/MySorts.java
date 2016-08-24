/**
*  This class implements a three different sorting algorithms commonly used 
* in data structures.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author    Henry Thomas 
*/

public class MySorts{
	private static int THRESHOLD = 5;

	public static void main(String[] args){
		/**
    	*  Main method for testing.
    	*/
		Comparable[] test1= {10,14,8,56,14,10};
		Comparable[] test2= {33,9,2,5};
		Comparable[] test3= null;
		Comparable[] test4= {8,10,35,14,11,36,55,4,1};
		Comparable[] test5= {3,7,2};
		Comparable[] test6= null;
		Comparable[] test7= {15,27,11,5,2,48,1,19,0,33,16};
		Comparable[] test8= {14,27,3,88,16};
		Comparable[] test9= null;

		System.out.println("Testing Insertion Sort...");
		insert(test1, 6);
		insert(test2, 4);
		insert(test3, 5);


		System.out.println("Testing Quick Sort...");
		quick(test4, 9);
		quick(test5, 3);
		quick(test6, 5);


		System.out.println("Testing Shell Sort...");
		shell(test7, 11);
		shell(test8, 5);
		shell(test9, 5);
	}

	public static void insert(Comparable [] arr, int n){
		/**
		* Sorts an array using the insertion sort method.
		*
		*@param arr[] Unsorted array which we will be sorted.
		*@param n The size of the array.
		*
		*/
		int i, j;
		if (arr != null && (n > 1)){
			if(n > arr.length)
				n = arr.length;
			for(i = 1; i < n; i++)
				for(j = i; (j > 0) && (arr[j].compareTo(arr[j - 1]) < 0); j--)
					swap(arr, j, j-1);
			for(i=0; i<n; i++)
				System.out.println(arr[i].toString() + " ");
			System.out.println();
		}
	}

	private static void insert(Comparable [] arr, int n, int s, int incr){
		/**
		* Sorts an array using the insertion sort method.
		*
		*@param arr[] Unsorted array which we will be sorted.
		*@param n The size of the array.
		*@param s The start location when performing an insertion.
		*@param incr This is the increment.
		*
		*/
		int i, j;
		if((arr != null) && (n > 1)){
			if(n > arr.length)
				n = arr.length;
			if((s >= 0 && s < n) && (incr >= 1 && incr < n)){
				for(i = s + incr; i < n; i += incr)
					for(j = i; (j > s) && (arr[j].compareTo(arr[j-incr]) < 0); j-=incr)
						swap(arr, j, j-incr);
			}
		}
	}

	private static void swap(Comparable[] arr, int x, int y){
		/**
		* Swaps two elements at positions x and y within an array.
		*
		*@param arr[] Unsorted array being used.
		*@param x index of the first element.
		*@param y index of the second element.
		*
		*/
		if(x != y){
			Comparable tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}
	}

	public static void quick(Comparable [] arr, int n){
		/**
		* Sorts an array using the quick sort method.
		*
		*@param arr[] Unsorted array which we will be sorted.
		*@param n The size of the array.
		*
		*/
		if((arr != null) && (n > 1)){
			if(n > arr.length)
				n = arr.length;
			else if(n < 5)
				insert(arr, n);
			quick(arr, 0, n - 1);
			for(int i = 0; i < n; i++)
				System.out.println(arr[i].toString() + " ");
			System.out.println();
		}
	}

	private static void quick(Comparable []arr, int l, int r){
		/**
		* Sorts an array using the quick sort method.
		*
		*@param arr[] Unsorted array to be sorted.
		*@param l The left part of our array.
		*@param r The right part of our array.
		*
		*/
		int p;
		int n = arr.length;
		if(n - l < THRESHOLD)
			insert(arr, r + 1, l, 1);
		if(l < r){
			p = findPivot(arr, l, r);
			swap(arr, l, r);
				p = partition(arr, l, r);
			swap(arr, p, r);
			quick(arr, l, p - l);
			quick(arr, p + 1, r);
		}
	}

	private static int findPivot(Comparable [] arr, int l, int r){
		/**
		* Locates the pivot point within our array.
		*
		*@param arr[] Unsorted array to be sorted.
		*@param l The left part of our array.
		*@param r The right part of our array.
		*
		*/
		return l + ((r - l)/2);
	}

	private static int partition(Comparable [] arr, int l, int r){
		/**
		* Partitions our array into left and right parts.
		*
		*@param arr[] Unsorted array to be sorted.
		*@param l The left part of our array.
		*@param r The right part of our array.
		*
		*/
		int i, j;
		for(i = l, j = r - l; i < j;){
			for(; arr[i].compareTo(arr[r]) < 0; i++)
				;
			for(; (j > l) && (arr[j].compareTo(arr[r]) >= 0); j--)
				;
			if(i < j)
				swap(arr, i++, j--);
		}
		return i;
	}

	public static void shell(Comparable [] arr, int n){
		/**
		* Sorts an array using the shell sort method.
		*
		*@param arr[] Unsorted array which we will be sorted.
		*@param n The size of the array.
		*
		*/
		int s, incr;
		if((arr != null) && (n > 1)){
			if (n > arr.length)
				n = arr.length;
			for(incr = n/2; incr > THRESHOLD; incr = (incr/2) + 1)
				for(s = 0; s < incr; s++)
					insert(arr, n, s, incr);
			insert(arr, n, 0, 1);
			for(int i = 0; i < n; i++)
				System.out.println(arr[i].toString() + " ");
			System.out.println();
		}	
	}
}