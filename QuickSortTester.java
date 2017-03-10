 public class QuickSortTester
 {
	 
	 public static void main( String[] args ) 
		{
		int[] buffer = {0,0};
		int[] arr1 = new int[1000];
		int[] arr2 = new int[2000];
		int[] arr3 = new int[3000];
		int[] arr4 = new int[4000];
		int[] arr5 = new int[5000];
		int[] arr6 = new int[6000];
		int[] arr7 = new int[7000];
		int[] arr8 = new int[8000];
		int[] arr9 = new int[9000];
		int[] arr10 = new int[10000];
		int[] arr11 = new int[20000];
		int[] arr12 = new int[30000];
		int[] arr13 = new int[40000];
		int[] arr14 = new int[50000];
		int[] arr15 = new int[60000];
		int[] arr16 = new int[70000];
		int[] arr17 = new int[80000];
		int[] arr18 = new int[11000];
		int[] arr19 = new int[90000];
		int[] arr20 = new int[100000];
		int[] arr21 = new int[110000];
		int[] arr22 = new int[200000];
		int[] arr23 = new int[300000];
		int[] arr24 = new int[400000];
		int[] arr25 = new int[500000];
		int[] arr26 = new int[600000];
		int[] arr27 = new int[700000];
		int[] arr28 = new int[800000];
		int[] arr29 = new int[900000];
		int[][] testArray = {arr1,arr2,arr3,arr4,arr5,arr6,arr7,arr8,arr9,arr10,arr11,arr12,arr13,arr14,arr15,arr16,arr17,arr18,arr19,arr20,arr21,arr22,arr23,arr24,arr25,arr26,arr27,arr28,arr29};
		for (int count = 0; count < testArray.length; count++) {
			for (int index = 0; index < testArray[count].length; index++) {
			testArray[count][index] = (int) (Math.random()*10000);
			}
		}

		long t0, t1, timeElapsed;
		String str = "";
		//Compile QuickSort before runtime is measured. 
		QuickSort.qsort(buffer);
		
		long[] totalResults = new long[testArray.length];
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
		for (int count = 0; count < testArray.length-1; count++) {
			totalResults[count] /= 30;
			System.out.println("Length: "+testArray[count+1].length+"\nTime: "+totalResults[count]);
		}

		}//end main
 }