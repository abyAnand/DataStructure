Time complexity using Big O

**Bubble Sort**
Best Time Complexity: best case O(n) When the array is already sorted.
Average Time Complexity: O(n^2)
Worst Time Complexity: O(n^2)

**Merge Sort**
O(n Log n):

The time complexity of MergeSort is O(n*Log n) in all the 3 cases
(worst, average and best).
As the mergesort always divides the array into two halves

**Quick Sort**
Best Case	O(n logn)
When the pivot element is the middle element or near to the middle element

Average Case	O(n logn
It occurs when the array elements are in jumbled order that is not properly ascending and not properly descending

Worst Case	O(n^2)
worst case occurs when the pivot element is either greatest or smallest element. 

**Insertion Sort**
Average and Worst: O(n^2)
Best: O(n)
this is the case when the list is already in the correct order
Insertion sort, on the other hand, works by building the sorted array one 
element at a time, by inserting each unsorted element into its proper position 
in the sorted array. In each iteration of the algorithm, the current unsorted
element is compared with the elements in the sorted part of the array and is
inserted into its correct position by shifting the larger elements to the right.

In the insertion sort algorithm, the outer loop iterates over all the elements of
the input array arr, and the inner loop iterates over the sorted part of the array
to find the correct position for the current unsorted element.

In the inner loop, the variable j is used to iterate over the sorted part of the
array, starting from the position of the last sorted element (i-1) and moving
backwards until it finds the correct position for the current unsorted element. 
This is because the sorted part of the array to the left of i-1 is already in 
the correct order, and j starts from the rightmost element of this sorted part.

So, j is initialized to i-1 because it represents the rightmost element of the 
sorted part of the array, which is the position immediately to the left of the
current unsorted element at position i. This ensures that the inner loop starts
from the correct position and moves backwards to find the correct position for 
the current unsorted element.

**Selection Sort**
Selection sort has a time complexity of O(n^2) in the worst and average case.
Does not work well on large datasets.
Selection sort works by repeatedly finding the minimum element from the unsorted
part of the array and placing it at the beginning of the sorted part of the array.
In each iteration of the algorithm, the smallest element from the remaining
unsorted part of the array is selected and swapped with the leftmost unsorted 
element.