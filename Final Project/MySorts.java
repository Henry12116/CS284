/**
*  This class implements selection sort as well as some of its necessairy methods. 
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
*/

public abstract class MySorts{

	public static void select(Comparable[] arr, int n){
		/**
		 * Sorts a comparable array using the selection sort method
		 *
		 * @param arr[], Unsorted array of comparables
		 * @param n, The number of elements in our array we want to sort. Starts from zero.
		 */
		int i, j, min;

		if (arr != null && arr.length > 1){
			if (n < 0) //Number of elements is less than 0
				n = 0;
			if (n > arr.length) //Number of elements greater than length of array
				n = arr.length;
			for (i = 0; i < n; i++){
				min = i;
				for (j = i; j < n; j++){
					if(arr[j].compareTo(arr[min]) < 0){
						min = j;
					}
				}
				if (min != i){
					swap(arr, min, i);
				}
			}
		}
	}

	private static void swap(Comparable[] arr, int i, int j){
		/**
		 * Swaps elements in a comparable array at positions i and j.
		 *
		 * @param arr[], The array of comparables to be sorted
		 * @param i, The index of the first element to be swapped
		 * @param j, The index of the second element to be swapped
		 */
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}


    public static String printArr(String[] arr){
    	/**
		 * Prints our array of strings. Works the similar to toString.
		 *
		 * @param  arr[], Array of strings to be printed.
		 */
    	String result = "";
    	if (arr != null && arr.length > 0){
			for (int i = 0; i < arr.length; i++){
	            if (i != 0)
	            	result += ", ";
	            result += arr[i];
	        }
    	}
    	else{
    		if (arr == null){
    			result = "null value";
    		}
    		else{
    			result = "empty array";
    		}
    	}
    	return result;
    }
}