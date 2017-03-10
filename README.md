# SortOfQuick <br> 
###### APCS2 Period 5: Brown Mykolyk
###### Jennifer Yu, Eric Zhang, Angel Ng
**Methodology:**<br> 
**Time Measurements:**<br> 
**Evaluation of QuickSort's runtime:**<br> 
[Graphs and Explanations](https://docs.google.com/document/d/16RJIrA6SCoNeSoqjFNfzsL3CF7ibyz0a6IO8B6nSwTo/pub)
**Question: What is the optimal pivot point?** <br> 
 * Using the middle index as the pivot (e.g. left+right / 2) doesn't always guarantee O(nlogn) runtime because of cases such as the following arrays: 
 <br> ``arr1 = {5, 3, 1, 0, 2, 4, 6}``
 <br> ``arr2 = {7, 5, 3, 1, 0, 2, 4, 6, 8}``
 <br> etc. 
 <br> Both of these arrays will take (n-1) x n passes in order to sort, which is O(n^2) runtime. 
 <br> 
 * Edges as pivots don't work very well because the pivot point is only incremented or decremented by one each time a recursive call is made, meaning that the two regions created are not evenly distributed.  
 * If your pivot point was always chosen to be the median of your region, then the algorithm would run in O(nlogn). However, there doesn't seem to be a way to find the median of an unsorted array with an O(n) runtime, which is needed to preserve the supposed O(nlogn) runtime of QuickSort. 
  * Suggested by PChan: utilizing bucket sort to find the median, but then Java has to sort the buckets anyways so...probably still O(n^2). 
  * Cutting down the min and max of the array each time also is an O(n^2) way of finding the median of an unsorted array.
 * **Best Option?** Choose a random pivot point everytime. With luck, more numbers are toward the middle than towards the ends? 
<br> <br> 
**Question: How does data arrangement affect runtime?**<br> 
 
 
