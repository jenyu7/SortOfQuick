# SortOfQuick <br> 
###### APCS2 Period 5: Brown Mykolyk
###### Jennifer Yu, Eric Zhang, Angel Ng
**Methodology:**<br> 
<ol> 
  <li> Create a multitude of arrays (in our case, we created 29 arrays, of size 1000, 1100, 2000, 3000...800000, 900000). Store these arrays in a 2D Array. </li> 
  <li> Run QuickSort on a buffer array, to warm up the JVM. </li> 
  <li> Using a for loop nested within a for loop, sort each array 30 times, taking the runtime each time using System.nanoTime(), and augmenting a term in an array which stores runtimes for all of the arrays. </li> 
  <li> Acquire the average of the runtimes for each array. </li>
  <li> Display the length and the average runtime in the terminal, and evaluate. </li> 
</ol> 
<br> 
@abhatt349 Credit for the idea of augmenting the size of the test arrays linearly instead of by a factor of 10 each time. 
<br> <br> 
**Time Measurements:**<br> 
![QuickSort Table](http://i.imgur.com/4847lZ2.png)
<br> <br> 
**Evaluation of QuickSort's runtime:**<br> 
[Graphs and Explanations](https://docs.google.com/document/d/16RJIrA6SCoNeSoqjFNfzsL3CF7ibyz0a6IO8B6nSwTo/pub)
<br><br>  
**Question: How does data arrangement affect runtime?**<br>
Depending on the data, the runtime can be nlog(n) or n^2. Because of this, it becomes difficult to choose the "best" pivot point in which an array would always be sorted in nlog(n) time. Since there is no way to predict the arrangement of an unsorted array input, it becomes difficult for QuickSort to anticipate the pivot point that would be able to most evenly distribute the regions of the array (pivot point would ideally be the median of the array). 
<br> <br>  
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
 * **Best Option:** Choose a random pivot point between the parameters left and right everytime. With luck, you may be able to hit upon a number that is the median of the region, or close to it. The disadvantage is that this is inconsistent. 
 * **Best Option 2:** Find the arithmetic mean, and then the number closest to it. However, this method: 1) assumes there are no/few outliers; 2) requires two linear searches [1 to find the arithmetic mean, one to find the number closest. 
 * **What we did:** We went with the random pivot point. It seems overall much simpler and easier to implement; it comes without the cost of having to run more searches or account for extremities, and it is far more likely for the pivot point to be chosen near the middle than at an extremity, such as the beginning or end of an array. 
<br> <br> 
 
 
 
