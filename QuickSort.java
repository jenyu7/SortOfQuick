/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
* 1. Summary of QuickSort algorithm:
 * QSort(arr): Using the helper function partition, divides the array into two regions around a pivot point, where the region to the left is numbers smaller than pvtVal and numbers to the right are larger. Using this concept, continue to subdivide the regions of the array until you reach a region of size 1 or less. Then, the array will have been sorted. 
 *
 * 2a. Worst pivot choice / array state and associated runtime: Worst pivot choice is a number at either the beginning or the end of the array. This is because everytime qsortHelp is called, the pivot point only increments/decrements by 1, meaning that the procedure needs to run a for loop n times, creating an n^2 runtime. 
 *
 * 2b. Best pivot choice / array state and associated runtime: Best pivot choice is a number in the middle of the array. This is because with each recursive call, the array's regions split halfway, creating more regions of smaller and larger numbers relative to their pivots. In this case, the for loop is only iterated in the fashion of a binary search. The for loop within partition is O(n) runtime and dividing is logn runtime, so combined the runtime is nlog(n) in best case. 
 *
 * 3. Approach to handling duplicate values in array: You don't need to. They end up gathering together. 
 *
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static int[] qsort( int[] d ) 
    { 
	return rqsort(d,0,d.length-1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.
    public static int[] rqsort(int[] arr, int left, int right) {
	if (left < right) {
	    int pvtPos = partition(arr,left,right,(left+right)/2);
	    rqsort(arr,left,pvtPos-1);
	    rqsort(arr,pvtPos+1,right);
	}
	return arr; 
    }

    //borrowed from pikachu's FastSelect.java
    public static int partition(int [] arr, int lb, int ub, int pivot){
	int v = arr[pivot];
	swap(ub, pivot, arr);
	int s = lb;
	for (int i = lb; i < ub; i++){
	    if (arr[i] < v) {
		swap(s, i, arr);
		s++;
	    }
	}
	swap(ub, s, arr);
	return s;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	//*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
