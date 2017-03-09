 public class QuickSortTester
 {
	 
	 public static void main( String[] args ) 
		{
		int[] buffer = {0,0};
		int[] arr1 = new int[1];
		int[] arr2 = new int[1];
		int[] arr3 = new int[10];
		int[] arr4 = new int[100];
		int[] arr5 = new int[1000];
		int[] arr6 = new int[10000];
		int[] arr7 = new int[100000];
		int[][] testArray = {arr1,arr2,arr3,arr4,arr5,arr6,arr7};
		for (int count = 0; count < testArray.length; count++) {
			for (int index = 0; index < testArray[count].length; index++) {
			testArray[count][index] = (int) (Math.random()*10000);
			}
		}

		long t0, t1, timeElapsed;
		String str = "";
		//Compile QuickSort before runtime is measured. 
		QuickSort.qsort(buffer);
		
		long[] totalResults = new long[7];
		for (int repeat = 0; repeat < 30; repeat++) {
			for (int count = 0; count < testArray.length; count++) {
			t0 = System.nanoTime();
			testArray[count] = QuickSort.qsort(testArray[count]);
			t1 = System.nanoTime();
			timeElapsed = t1 - t0;
			//str += "Length ("+testArray[count].length+"): "+timeElapsed + "\n";
			if (count > 0)
				totalResults[count-1] += timeElapsed;
			
			}
			//System.out.println(str);
		
		}
		for (int count = 0; count < 6; count++) {
			totalResults[count] /= 30;
			System.out.println("Length: "+testArray[count+1].length+"\nTime: "+totalResults[count]);
		}

		}//end main
 }