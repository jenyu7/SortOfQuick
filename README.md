# SortOfQuick <br> 
###### APCS2 Period 5: Brown Mykolyk
###### Jennifer Yu, Eric Zhang, Angel Ng
**Question: What is the optimal pivot point?** <br> 
 * Middle doesn't work because of following arrays: 
 <br> ``arr1 = {5, 3, 1, 0, 2, 4, 6}``
 <br> ``arr2 = {7, 5, 3, 1, 0, 2, 4, 6, 8}``
 <br> etc. 
 <br> Both of these arrays will take (n-1) x n passes in order to sort, which is O(n^2) runtime. 
 <br> 
 * Edges don't work very well because the pivot point is only incremented or decremented by one each time a recursive call is made. 
 * If your pivot point was always chosen to be the median of your region, then the algorithm would run in O(nlogn). However, there doesn't seem to be a way to find the median of an unsorted array with an O(n) runtime, which is needed to preserve the supposed O(nlogn) runtime of QuickSort. 
  * Suggested by PChan: utilizing bucket sort to find the median, but then Java has to sort the buckets anyways so...probably still O(n^2). 
  * Cutting down the min and max of the array each time also is an O(n^2) way of finding the median of an unsorted array.
 * **Best Option?** Choose a random pivot point everytime. With luck, more numbers are toward the middle than towards the ends? 
 
 
